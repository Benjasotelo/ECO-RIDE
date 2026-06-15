package com.ecoride.ms_notificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificacionRequestDTO {
    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;

    private String tipo;
}