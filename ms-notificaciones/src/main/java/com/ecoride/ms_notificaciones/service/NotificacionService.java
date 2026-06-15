package com.ecoride.ms_notificaciones.service;

import com.ecoride.ms_notificaciones.dto.NotificacionRequestDTO;
import com.ecoride.ms_notificaciones.dto.NotificacionResponseDTO;
import com.ecoride.ms_notificaciones.model.Notificacion;
import com.ecoride.ms_notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public NotificacionResponseDTO registrarYEnviar(NotificacionRequestDTO request) {
        Notificacion notificacion = new Notificacion();
        notificacion.setUsuarioId(request.getUsuarioId());
        notificacion.setMensaje(request.getMensaje());
        notificacion.setTipo(request.getTipo() != null ? request.getTipo() : "CORREO");
        notificacion.setEstado("ENVIADO"); // Simulación de envío
        notificacion.setFechaEnvio(LocalDateTime.now());

        Notificacion guardada = notificacionRepository.save(notificacion);
        return mapToDTO(guardada);
    }

    public List<NotificacionResponseDTO> listarPorUsuario(Long usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private NotificacionResponseDTO mapToDTO(Notificacion notificacion) {
        return NotificacionResponseDTO.builder()
                .id(notificacion.getId())
                .mensaje(notificacion.getMensaje())
                .estado(notificacion.getEstado())
                .fechaEnvio(notificacion.getFechaEnvio())
                .build();
    }
}