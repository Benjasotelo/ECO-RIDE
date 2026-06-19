package com.ecoride.ms_calificaciones.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con datos de la calificación")
public class CalificacionResponseDTO {
    @Schema(description = "ID de la calificación", example = "1")
    private Long id;
    @Schema(description = "Estrellas otorgadas (1 a 5)", example = "5")
    private Integer estrellas;
    @Schema(description = "Comentario de la calificación", example = "Excelente conductor")
    private String comentario;
    @Schema(description = "Fecha de la calificación", example = "2024-01-15T10:30:00")
    private LocalDateTime fecha;
}