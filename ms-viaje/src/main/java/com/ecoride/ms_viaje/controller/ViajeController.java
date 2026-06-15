package com.ecoride.ms_viaje.controller;

import com.ecoride.ms_viaje.dto.ViajeRequestDTO;
import com.ecoride.ms_viaje.dto.ViajeResponseDTO;
import com.ecoride.ms_viaje.service.ViajeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
@RequiredArgsConstructor
public class ViajeController {

    private final ViajeService viajeService;

    @PostMapping
    public ResponseEntity<ViajeResponseDTO> solicitarViaje(@Valid @RequestBody ViajeRequestDTO request) {
        return ResponseEntity.ok(viajeService.crearViaje(request));
    }

    @GetMapping("/activos")
    public ResponseEntity<List<ViajeResponseDTO>> obtenerActivos() {
        return ResponseEntity.ok(viajeService.listarViajesActivos());
    }
}