package com.ecoride.ms_pago.controller;

import com.ecoride.ms_pagos.dto.PagoRequestDTO;
import com.ecoride.ms_pago.dto.PagoResponseDTO;
import com.ecoride.ms_pago.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    // Obtener historial: GET /api/pagos/usuario/1
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PagoResponseDTO>> obtenerHistorial(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(pagoService.listarPorUsuario(usuarioId));
    }

    // Crear pago: POST /api/pagos (Enviando JSON del RequestDTO)
    @PostMapping
    public ResponseEntity<PagoResponseDTO> crearPago(@Valid @RequestBody PagoRequestDTO request) {
        return ResponseEntity.ok(pagoService.registrarPago(request));
    }
}