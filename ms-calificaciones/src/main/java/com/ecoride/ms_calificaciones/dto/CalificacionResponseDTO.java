package com.ecoride.ms_calificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalificacionResponseDTO {
    private Long id;
    private Integer estrellas;
    private String comentario;
    private LocalDateTime fecha;
}