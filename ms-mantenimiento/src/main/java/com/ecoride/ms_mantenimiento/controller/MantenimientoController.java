package com.ecoride.ms_mantenimiento.controller;

import com.ecoride.ms_mantenimiento.dto.MantenimientoRequestDTO;
import com.ecoride.ms_mantenimiento.dto.MantenimientoResponseDTO;
import com.ecoride.ms_mantenimiento.service.MantenimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
@RequiredArgsConstructor
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    @PostMapping
    public ResponseEntity<MantenimientoResponseDTO> ingresar(@Valid @RequestBody MantenimientoRequestDTO request) {
        return ResponseEntity.ok(mantenimientoService.registrarIngreso(request));
    }

    @GetMapping("/activos")
    public ResponseEntity<List<MantenimientoResponseDTO>> obtenerActivos() {
        return ResponseEntity.ok(mantenimientoService.listarActivos());
    }
}