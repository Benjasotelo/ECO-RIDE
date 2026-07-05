package com.ecoride.ms_geolocalizacion.service;

import com.ecoride.ms_geolocalizacion.dto.UbicacionRequestDTO;
import com.ecoride.ms_geolocalizacion.dto.UbicacionResponseDTO;
import com.ecoride.ms_geolocalizacion.model.Ubicacion;
import com.ecoride.ms_geolocalizacion.repository.UbicacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    public UbicacionResponseDTO actualizarUbicacion(UbicacionRequestDTO request) {
        Ubicacion ubicacion = ubicacionRepository.findByVehiculoId(request.getVehiculoId())
                .orElse(new Ubicacion());

        ubicacion.setVehiculoId(request.getVehiculoId());
        ubicacion.setLatitud(request.getLatitud());
        ubicacion.setLongitud(request.getLongitud());
        ubicacion.setUltimaActualizacion(LocalDateTime.now());

        Ubicacion guardada = ubicacionRepository.save(ubicacion);
        return mapToDTO(guardada);
    }

    public UbicacionResponseDTO obtenerPorVehiculo(Long vehiculoId) {
        Ubicacion ubicacion = ubicacionRepository.findByVehiculoId(vehiculoId)
                .orElseThrow(() -> new RuntimeException("No se encontró ubicación para el vehículo: " + vehiculoId));
        return mapToDTO(ubicacion);
    }

    private UbicacionResponseDTO mapToDTO(Ubicacion u) {
        return UbicacionResponseDTO.builder()
                .vehiculoId(u.getVehiculoId())
                .latitud(u.getLatitud())
                .longitud(u.getLongitud())
                .actualizadoEn(u.getUltimaActualizacion().toString())
                .build();
    }
}