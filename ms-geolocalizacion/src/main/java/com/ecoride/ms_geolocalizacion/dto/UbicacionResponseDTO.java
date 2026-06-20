package com.ecoride.ms_geolocalizacion.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Respuesta con la ubicación del vehículo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UbicacionResponseDTO {

    @Schema(description = "ID del vehículo", example = "1")
    private Long vehiculoId;

    @Schema(description = "Latitud de la ubicación", example = "-33.4489")
    private Double latitud;

    @Schema(description = "Longitud de la ubicación", example = "-70.6693")
    private Double longitud;

    @Schema(description = "Fecha y hora de la última actualización", example = "2024-01-15T10:30:00")
    private String actualizadoEn;
}