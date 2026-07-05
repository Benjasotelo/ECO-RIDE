package com.ecoride.ms_pago.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con datos del pago")
public class PagoResponseDTO extends RepresentationModel<PagoResponseDTO> {

    @Schema(description = "ID del pago", example = "1")
    private Long id;

    @Schema(description = "ID del usuario", example = "1")
    private Long usuarioId;

    @Schema(description = "Monto del pago", example = "15000.0")
    private Double monto;

    @Schema(description = "Estado del pago", example = "COMPLETADO")
    private String estado;

    @Schema(description = "Fecha del pago", example = "2024-01-15T10:30:00")
    private LocalDateTime fecha;
}