package com.ecoride.ms_notificaciones.controller;

import com.ecoride.ms_notificaciones.dto.NotificacionRequestDTO;
import com.ecoride.ms_notificaciones.dto.NotificacionResponseDTO;
import com.ecoride.ms_notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<NotificacionResponseDTO> enviar(@Valid @RequestBody NotificacionRequestDTO request) {
        return ResponseEntity.ok(notificacionService.registrarYEnviar(request));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<NotificacionResponseDTO>> historial(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(notificacionService.listarPorUsuario(usuarioId));
    }
}