# ECO-RIDE

Proyecto de arquitectura de microservicios para una plataforma de viajes compartidos (estilo carpooling), desarrollado para el ramo de Desarrollo Fullstack I.

La idea detrás de EcoRide es simple: conectar personas que quieren compartir un viaje, reduciendo costos y huella de carbono. El backend está separado en servicios independientes, cada uno con su propia base de datos, comunicados entre sí a través de Eureka (descubrimiento de servicios) y un API Gateway.

## Arquitectura

El sistema funciona bajo el patrón de microservicios con Spring Cloud:

- **Eureka Server**: es el "directorio" donde todos los microservicios se registran al arrancar. Gracias a esto, el Gateway y los servicios entre sí no necesitan saber IPs fijas, solo el nombre del servicio.
- **API Gateway**: es el único punto de entrada para los clientes (Postman, un frontend, etc). Recibe las peticiones en el puerto 8091 y las redirige internamente al microservicio correspondiente según la ruta.
- **10 microservicios de dominio**, cada uno con su propia base de datos MySQL (nada de compartir tablas entre servicios, cada uno es dueño de su información).

Cada microservicio corre en su propio contenedor Docker, con su propia base de datos también en Docker, para que todo el ambiente se pueda levantar con un solo comando sin tener que instalar MySQL, Java o Maven manualmente.

## Microservicios

### eureka-server (puerto 8761)
El servidor de descubrimiento. No maneja lógica de negocio, solo lleva el registro de qué microservicios están arriba y en qué dirección. Se puede ver el panel de control en `http://localhost:8761`.

### ms-gateway (puerto 8091)
La puerta de entrada de toda la aplicación. Reescribe las rutas externas (`/api/v1/...`) hacia las rutas internas de cada microservicio y hace de balanceador usando el registro de Eureka.

### ms-usuario (puerto 8081)
Maneja el registro y administración de usuarios de la plataforma: conductores y pasajeros. Guarda datos como nombre, correo, rol (admin, conductor, pasajero) y estado de la cuenta.

### ms-perfiles (puerto 8082)
Se encarga de la información extendida de cada usuario que no calza directamente en la tabla de usuarios: datos de licencia de conducir, información de contacto adicional, ese tipo de cosas. Está separado de `ms-usuario` para no mezclar autenticación con datos de perfil.

### ms-vehiculo (puerto 8083)
Registro de los vehículos que se usan para hacer los viajes: patente, marca, modelo, capacidad de pasajeros, y a qué conductor pertenece cada uno.

### ms-geolocalizacion (puerto 8084)
Guarda y actualiza la ubicación de los vehículos en tiempo real (o casi real), para poder mostrar dónde está un conductor durante un viaje activo.

### ms-viaje (puerto 8085)
El corazón del sistema. Acá se crea un viaje, se le asigna un conductor y pasajeros, se controla su estado (pendiente, en curso, finalizado, cancelado) y se conecta con `ms-vehiculo` para saber qué auto se está usando.

### ms-precio (puerto 8086)
Calcula el costo de cada viaje según distancia, tipo de vehículo, u otras reglas de negocio que se definan. Se mantiene separado de `ms-viaje` para que la lógica de tarifas se pueda modificar sin tocar el servicio de viajes.

### ms-pago (puerto 8087)
Procesa el pago asociado a un viaje una vez calculado el precio: método de pago, estado del pago (pendiente, completado), y el monto final.

### ms-notificaciones (puerto 8088)
Envía notificaciones a los usuarios (por ejemplo, cuando un viaje es aceptado o cuando llega el conductor). En este proyecto está simulado, no conectado a un proveedor real de correo o SMS.

### ms-calificaciones (puerto 8089)
Permite que conductores y pasajeros se califiquen entre ellos después de un viaje, guardando puntaje y comentario.

### ms-mantenimiento (puerto 8090)
Lleva el registro de mantenciones hechas a cada vehículo (revisiones técnicas, cambios de aceite, etc), útil para llevar un historial y saber si un vehículo está habilitado para seguir operando.

## Tecnologías usadas

- Java 21 + Spring Boot 3
- Spring Cloud (Eureka, Gateway)
- Spring Data JPA + MySQL
- Flyway para el versionado de la base de datos
- Docker y Docker Compose para levantar todo el ambiente
- Maven como gestor de dependencias

## Cómo levantar el proyecto

Con Docker instalado, desde la raíz del proyecto:

```bash
docker compose up --build
```

Esto va a:
1. Bajar las imágenes de MySQL, Maven y Java necesarias.
2. Compilar los 12 microservicios dentro de sus propios contenedores.
3. Levantar 10 bases de datos MySQL (una por microservicio) más los 12 servicios, en el orden correcto.

La primera vez tarda varios minutos porque tiene que compilar todo. Las siguientes veces es mucho más rápido.

Una vez levantado, se puede revisar que todo esté registrado correctamente en `http://localhost:8761` (panel de Eureka), y probar los endpoints a través del gateway en `http://localhost:8091`.

## Notas

- Cada microservicio tiene su propia base de datos, siguiendo el principio de "database per service" típico de arquitecturas de microservicios.
- Las migraciones de base de datos se manejan con Flyway, así que las tablas se crean automáticamente al levantar cada servicio, no hay que correr scripts SQL a mano.
- La configuración de conexión a base de datos y a Eureka usa variables de entorno con valores por defecto, así que el mismo código funciona tanto corriendo local como dentro de Docker.
