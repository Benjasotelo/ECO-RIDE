package com.ecoride.ms_vehiculo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Schema(description = "Respuesta con datos del vehículo")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoResponseDTO extends RepresentationModel<VehiculoResponseDTO> {

    @Schema(description = "ID del vehículo", example = "1")
    private Long id;

    @Schema(description = "Placa del vehículo", example = "ABC123")
    private String placa;

    @Schema(description = "Tipo de vehículo", example = "AUTO")
    private String tipo;

    @Schema(description = "Estado del vehículo", example = "DISPONIBLE")
    private String estado;
}