package com.ecoride.ms_mantenimiento.model;

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
@Table(name = "mantenimientos")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del vehículo es obligatorio")
    private Long vehiculoId;

    @NotBlank(message = "La descripción del fallo o servicio es obligatoria")
    private String descripcion;

    private String tecnicoResponsable;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;

    private String estado; // EN_REPARACION, COMPLETADO, CANCELADO
}