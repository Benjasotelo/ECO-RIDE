package com.ecoride.ms_viaje.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViajeResponseDTO {
    private Long id;
    private String origen;
    private String destino;
    private Double costoTotal;
    private String estado;
    private LocalDateTime fechaInicio;
}