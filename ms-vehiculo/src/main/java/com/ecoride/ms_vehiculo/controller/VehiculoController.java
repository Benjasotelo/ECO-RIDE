package com.ecoride.ms_vehiculo.controller;

import com.ecoride.ms_vehiculo.dto.VehiculoRequestDTO;
import com.ecoride.ms_vehiculo.dto.VehiculoResponseDTO;
import com.ecoride.ms_vehiculo.service.VehiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping("/disponibles")
    public ResponseEntity<List<VehiculoResponseDTO>> obtenerDisponibles() {
        return ResponseEntity.ok(vehiculoService.listarDisponibles());
    }

    @PostMapping
    public ResponseEntity<VehiculoResponseDTO> guardar(@Valid @RequestBody VehiculoRequestDTO request) {
        return ResponseEntity.ok(vehiculoService.registrar(request));
    }
}