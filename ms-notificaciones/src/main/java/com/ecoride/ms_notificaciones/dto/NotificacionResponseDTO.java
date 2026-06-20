package com.ecoride.ms_notificaciones.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Schema(description = "Respuesta con datos de la notificación")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionResponseDTO {

    @Schema(description = "ID de la notificación", example = "1")
    private Long id;

    @Schema(description = "Mensaje enviado", example = "Tu viaje ha sido confirmado")
    private String mensaje;

    @Schema(description = "Estado del envío", example = "ENVIADO")
    private String estado;

    @Schema(description = "Fecha y hora de envío", example = "2024-01-15T10:30:00")
    private LocalDateTime fechaEnvio;
}