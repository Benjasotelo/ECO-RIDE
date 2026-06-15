package com.ecoride.ms_notificaciones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    private String tipo; // CORREO, SMS, PUSH
    private String estado; // ENVIADO, FALLIDO
    private LocalDateTime fechaEnvio;
}