package com.ecoride.ms_geolocalizacion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UbicacionResponseDTO {
    private Long vehiculoId;
    private Double latitud;
    private Double longitud;
    private String actualizadoEn;
}