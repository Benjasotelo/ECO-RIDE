package com.ecoride.ms_pago.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoResponseDTO {
    private Long id;
    private Long usuarioId;
    private Double monto;
    private String estado;
    private LocalDateTime fecha;
}