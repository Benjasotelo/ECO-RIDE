package com.ecoride.ms_geolocalizacion.controller;

import com.ecoride.ms_geolocalizacion.dto.UbicacionRequestDTO;
import com.ecoride.ms_geolocalizacion.dto.UbicacionResponseDTO;
import com.ecoride.ms_geolocalizacion.service.UbicacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubicaciones")
@RequiredArgsConstructor
public class UbicacionController {

    private final UbicacionService ubicacionService;

    @PostMapping("/actualizar")
    public ResponseEntity<UbicacionResponseDTO> actualizar(@Valid @RequestBody UbicacionRequestDTO request) {
        return ResponseEntity.ok(ubicacionService.actualizarUbicacion(request));
    }

    @GetMapping("/vehiculo/{id}")
    public ResponseEntity<UbicacionResponseDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(ubicacionService.obtenerPorVehiculo(id));
    }
}