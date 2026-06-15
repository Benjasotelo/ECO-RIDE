package com.ecoride.ms_precio.dto;

import lombok.Data;

@Data
public class PrecioRequestDTO {
    private String tipoVehiculo;
    private Double valorBase;
    private Double valorPorKilometro;
}