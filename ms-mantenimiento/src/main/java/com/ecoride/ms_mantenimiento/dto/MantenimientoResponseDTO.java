package com.ecoride.ms_mantenimiento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MantenimientoResponseDTO {
    private Long id;
    private Long vehiculoId;
    private String estado;
    private LocalDateTime fechaEntrada;
}