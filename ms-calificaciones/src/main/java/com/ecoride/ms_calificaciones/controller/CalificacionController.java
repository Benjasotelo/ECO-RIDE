package com.ecoride.ms_calificaciones.controller;

import com.ecoride.ms_calificaciones.dto.CalificacionRequestDTO;
import com.ecoride.ms_calificaciones.dto.CalificacionResponseDTO;
import com.ecoride.ms_calificaciones.service.CalificacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
@RequiredArgsConstructor
public class CalificacionController {

    private final CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<CalificacionResponseDTO> crear(@Valid @RequestBody CalificacionRequestDTO request) {
        return ResponseEntity.ok(calificacionService.crearCalificacion(request));
    }

    @GetMapping("/receptor/{id}")
    public ResponseEntity<List<CalificacionResponseDTO>> listar(@PathVariable Long id) {
        return ResponseEntity.ok(calificacionService.obtenerPorUsuario(id));
    }
}