package com.ecoride.ms_viaje.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoDTO {
    private Long id;
    private String placa;
    private String tipo;
    private String estado;
}