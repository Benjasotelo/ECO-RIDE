package com.ecoride.ms_vehiculo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoResponseDTO {
    private Long id;
    private String placa;
    private String tipo;
    private String estado;
}