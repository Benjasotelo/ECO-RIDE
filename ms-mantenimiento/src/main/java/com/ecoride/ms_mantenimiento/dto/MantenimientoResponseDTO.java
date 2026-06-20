package com.ecoride.ms_mantenimiento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Schema(description = "Respuesta con datos del mantenimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MantenimientoResponseDTO {

    @Schema(description = "ID del mantenimiento", example = "1")
    private Long id;

    @Schema(description = "ID del vehículo asociado", example = "1")
    private Long vehiculoId;

    @Schema(description = "Estado del mantenimiento", example = "EN_REPARACION")
    private String estado;

    @Schema(description = "Fecha de ingreso a mantenimiento", example = "2024-01-15T10:30:00")
    private LocalDateTime fechaEntrada;
}