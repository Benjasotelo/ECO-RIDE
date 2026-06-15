package com.ecoride.ms_mantenimiento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MantenimientoRequestDTO {
    @NotNull(message = "Debe indicar el vehículo")
    private Long vehiculoId;
    @NotBlank(message = "Debe describir el trabajo a realizar")
    private String descripcion;
    private String tecnicoResponsable;
}