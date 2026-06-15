package com.ecoride.ms_mantenimiento.service;

import com.ecoride.ms_mantenimiento.dto.MantenimientoRequestDTO;
import com.ecoride.ms_mantenimiento.dto.MantenimientoResponseDTO;
import com.ecoride.ms_mantenimiento.model.Mantenimiento;
import com.ecoride.ms_mantenimiento.repository.MantenimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MantenimientoService {

    private final MantenimientoRepository repository;

    public MantenimientoResponseDTO registrarIngreso(MantenimientoRequestDTO request) {
        Mantenimiento m = new Mantenimiento();
        m.setVehiculoId(request.getVehiculoId());
        m.setDescripcion(request.getDescripcion());
        m.setTecnicoResponsable(request.getTecnicoResponsable());
        m.setFechaEntrada(LocalDateTime.now());
        m.setEstado("EN_REPARACION");

        Mantenimiento guardado = repository.save(m);
        return mapToDTO(guardado);
    }

    public List<MantenimientoResponseDTO> listarActivos() {
        return repository.findByEstado("EN_REPARACION").stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private MantenimientoResponseDTO mapToDTO(Mantenimiento m) {
        return MantenimientoResponseDTO.builder()
                .id(m.getId())
                .vehiculoId(m.getVehiculoId())
                .estado(m.getEstado())
                .fechaEntrada(m.getFechaEntrada())
                .build();
    }
}