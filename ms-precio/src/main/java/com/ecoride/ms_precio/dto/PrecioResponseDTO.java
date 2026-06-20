package com.ecoride.ms_precio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Respuesta con el cálculo del precio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrecioResponseDTO {

    @Schema(description = "Tipo de vehículo", example = "AUTO")
    private String tipoVehiculo;

    @Schema(description = "Precio total calculado", example = "8500.0")
    private Double precioTotal;

    @Schema(description = "Distancia en kilómetros", example = "10.5")
    private Double distanciaKm;
}