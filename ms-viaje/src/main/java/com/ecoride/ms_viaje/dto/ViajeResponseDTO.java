package com.ecoride.ms_viaje.dto;

import org.springframework.hateoas.RepresentationModel;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViajeResponseDTO extends RepresentationModel<ViajeResponseDTO> {
    private Long id;
    private Long pasajeroId;
    private Long conductorId;
    private String origen;
    private String destino;
    private String estado;
}