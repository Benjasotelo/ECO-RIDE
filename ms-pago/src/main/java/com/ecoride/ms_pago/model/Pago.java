package com.ecoride.ms_pago.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser mayor a cero")
    private Double monto;

    private String metodoPago; // Ejemplo: DEBITO, CREDITO, BILLETERA
    private String estado;     // Ejemplo: COMPLETADO, PENDIENTE
    private LocalDateTime fecha;
}