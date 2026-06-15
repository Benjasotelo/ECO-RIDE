package com.ecoride.ms_precio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrecioResponseDTO {
    private String tipoVehiculo;
    private Double precioTotal;
    private Double distanciaKm;
}