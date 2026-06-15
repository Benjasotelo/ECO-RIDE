package com.ecoride.ms_calificaciones.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalificacionRequestDTO {
    @NotNull private Long viajeId;
    @NotNull private Long emisorId;
    @NotNull private Long receptorId;
    @Min(1) @Max(5) private Integer estrellas;
    private String comentario;
}