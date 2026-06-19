package com.ecoride.ms_vehiculo.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con datos del vehículo")
public class VehiculoResponseDTO {
    @Schema(description = "ID del vehículo", example = "1")
    private Long id;
    @Schema(description = "Placa del vehículo", example = "ABC123")
    private String placa;
    @Schema(description = "Tipo de vehículo", example = "AUTO")
    private String tipo;
    @Schema(description = "Estado del vehículo", example = "DISPONIBLE")
    private String estado;
}