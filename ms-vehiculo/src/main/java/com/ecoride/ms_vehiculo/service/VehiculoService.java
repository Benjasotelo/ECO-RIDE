package com.ecoride.ms_vehiculo.service;

import com.ecoride.ms_vehiculo.dto.VehiculoRequestDTO;
import com.ecoride.ms_vehiculo.dto.VehiculoResponseDTO;
import com.ecoride.ms_vehiculo.model.Vehiculo;
import com.ecoride.ms_vehiculo.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public List<VehiculoResponseDTO> listarDisponibles() {
        return vehiculoRepository.findByEstado("DISPONIBLE").stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public VehiculoResponseDTO obtenerPorId(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));
        return mapToDTO(vehiculo);
    }

    public VehiculoResponseDTO registrar(VehiculoRequestDTO request) {
        Vehiculo v = new Vehiculo();
        v.setPlaca(request.getPlaca());
        v.setTipo(request.getTipo());
        v.setModelo(request.getModelo());
        v.setEstado("DISPONIBLE");
        v.setNivelBateria(100.0);

        return mapToDTO(vehiculoRepository.save(v));
    }

    private VehiculoResponseDTO mapToDTO(Vehiculo v) {
        return VehiculoResponseDTO.builder()
                .id(v.getId())
                .placa(v.getPlaca())
                .tipo(v.getTipo())
                .estado(v.getEstado())
                .build();
    }
}