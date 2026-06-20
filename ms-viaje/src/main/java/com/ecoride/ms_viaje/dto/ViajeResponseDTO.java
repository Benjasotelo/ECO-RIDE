package com.ecoride.ms_viaje.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Schema(description = "Respuesta con datos del viaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViajeResponseDTO {

    @Schema(description = "ID del viaje", example = "1")
    private Long id;

    @Schema(description = "Dirección de origen", example = "Av. Providencia 123")
    private String origen;

    @Schema(description = "Dirección de destino", example = "Av. Apoquindo 456")
    private String destino;

    @Schema(description = "Costo total del viaje", example = "8500.0")
    private Double costoTotal;

    @Schema(description = "Estado del viaje", example = "EN_CURSO")
    private String estado;

    @Schema(description = "Fecha y hora de inicio", example = "2024-01-15T10:30:00")
    private LocalDateTime fechaInicio;
}