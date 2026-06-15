package com.ecoride.ms_vehiculo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VehiculoRequestDTO {
    @NotBlank(message = "Placa necesaria")
    private String placa;
    @NotBlank(message = "Tipo necesario")
    private String tipo;
    private String modelo;
}