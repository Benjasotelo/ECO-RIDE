package com.ecoride.ms_viaje.service;

import com.ecoride.ms_viaje.clients.VehiculoClient;
import com.ecoride.ms_viaje.dto.VehiculoDTO;
import com.ecoride.ms_viaje.dto.ViajeRequestDTO;
import com.ecoride.ms_viaje.dto.ViajeResponseDTO;
import com.ecoride.ms_viaje.model.Viaje;
import com.ecoride.ms_viaje.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j; // Para los logs
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ViajeService {

    private final ViajeRepository viajeRepository;
    private final VehiculoClient vehiculoClient;

    public ViajeResponseDTO crearViaje(ViajeRequestDTO request) {
        log.info("Iniciando creación de viaje para el pasajero ID: {}", request.getPasajeroId());

        // --- COMUNICACIÓN CON MS-VEHICULO ---
        // Supongamos que el request trae un vehiculoId
        try {
            log.info("Consultando datos del vehículo en ms-vehiculo...");

        } catch (Exception e) {
            log.warn("No se pudo verificar el vehículo, pero procedemos con la lógica local: {}", e.getMessage());
        }
        // ------------------------------------

        Viaje viaje = new Viaje();
        viaje.setPasajeroId(request.getPasajeroId());
        viaje.setOrigen(request.getOrigen());
        viaje.setDestino(request.getDestino());
        viaje.setTipoVehiculo(request.getTipoVehiculo());
        viaje.setDistanciaKm(request.getDistanciaKm());

        viaje.setCostoTotal(request.getDistanciaKm() * 500.0);
        viaje.setEstado("SOLICITADO");
        viaje.setFechaInicio(LocalDateTime.now());

        Viaje guardado = viajeRepository.save(viaje);
        log.info("Viaje guardado exitosamente con ID: {}", guardado.getId());

        return mapToDTO(guardado);
    }

    public List<ViajeResponseDTO> listarViajesActivos() {
        log.info("Listando viajes con estado SOLICITADO");
        return viajeRepository.findByEstado("SOLICITADO").stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ViajeResponseDTO mapToDTO(Viaje viaje) {
        return ViajeResponseDTO.builder()
                .id(viaje.getId())
                .origen(viaje.getOrigen())
                .destino(viaje.getDestino())
                .estado(viaje.getEstado())

                .build();
    }
}