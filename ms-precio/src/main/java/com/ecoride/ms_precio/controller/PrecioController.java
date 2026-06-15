package com.ecoride.ms_precio.controller;

import com.ecoride.ms_precio.dto.PrecioResponseDTO;
import com.ecoride.ms_precio.service.PrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/precios")
@RequiredArgsConstructor
public class PrecioController {

    private final PrecioService precioService;

    // Endpoint para calcular: /api/precios/calcular?tipo=AUTO&km=10.5
    @GetMapping("/calcular")
    public ResponseEntity<PrecioResponseDTO> calcular(@RequestParam String tipo, @RequestParam Double km) {
        return ResponseEntity.ok(precioService.calcularPrecioFinal(tipo, km));
    }
}