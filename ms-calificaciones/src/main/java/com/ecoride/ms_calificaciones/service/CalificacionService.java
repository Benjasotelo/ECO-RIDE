package com.ecoride.ms_calificaciones.service;

import com.ecoride.ms_calificaciones.dto.CalificacionRequestDTO;
import com.ecoride.ms_calificaciones.dto.CalificacionResponseDTO;
import com.ecoride.ms_calificaciones.model.Calificacion;
import com.ecoride.ms_calificaciones.repository.CalificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    public CalificacionResponseDTO crearCalificacion(CalificacionRequestDTO request) {
        Calificacion c = new Calificacion();
        c.setViajeId(request.getViajeId());
        c.setEmisorId(request.getEmisorId());
        c.setReceptorId(request.getReceptorId());
        c.setEstrellas(request.getEstrellas());
        c.setComentario(request.getComentario());
        c.setFecha(LocalDateTime.now());

        Calificacion guardada = calificacionRepository.save(c);
        return mapToDTO(guardada);
    }

    public List<CalificacionResponseDTO> obtenerPorUsuario(Long receptorId) {
        return calificacionRepository.findByReceptorId(receptorId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CalificacionResponseDTO mapToDTO(Calificacion c) {
        return CalificacionResponseDTO.builder()
                .id(c.getId())
                .estrellas(c.getEstrellas())
                .comentario(c.getComentario())
                .fecha(c.getFecha())
                .build();
    }
}