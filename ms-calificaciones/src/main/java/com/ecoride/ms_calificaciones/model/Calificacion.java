package com.ecoride.ms_calificaciones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
//h
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calificaciones")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del viaje es obligatorio")
    private Long viajeId;

    @NotNull(message = "El ID del emisor es obligatorio")
    private Long emisorId;

    @NotNull(message = "El ID del receptor es obligatorio")
    private Long receptorId;

    @Min(1) @Max(5)
    @NotNull(message = "La puntuación es obligatoria")
    private Integer estrellas;

    private String comentario;
    private LocalDateTime fecha;
}