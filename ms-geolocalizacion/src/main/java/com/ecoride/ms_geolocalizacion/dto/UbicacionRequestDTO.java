package com.ecoride.ms_geolocalizacion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UbicacionRequestDTO {
    @NotNull(message = "Vehículo ID requerido")
    private Long vehiculoId;
    @NotNull(message = "Latitud requerida")
    private Double latitud;
    @NotNull(message = "Longitud requerida")
    private Double longitud;
}