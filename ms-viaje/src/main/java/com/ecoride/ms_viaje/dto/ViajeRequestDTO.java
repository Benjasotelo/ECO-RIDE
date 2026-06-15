package com.ecoride.ms_viaje.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ViajeRequestDTO {
    @NotNull(message = "ID de pasajero necesario")
    private Long pasajeroId;
    @NotBlank(message = "Origen necesario")
    private String origen;
    @NotBlank(message = "Destino necesario")
    private String destino;
    @NotNull(message = "Debe indicar el tipo de vehículo")
    private String tipoVehiculo;
    private Double distanciaKm;
}