package com.ecoride.ms_pago.controller;

import com.ecoride.ms_pagos.dto.PagoRequestDTO;
import com.ecoride.ms_pago.dto.PagoResponseDTO;
import com.ecoride.ms_pago.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Pagos", description = "Operaciones relacionadas con pagos")
@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @Operation(summary = "Obtener historial de pagos por usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Historial obtenido correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CollectionModel<PagoResponseDTO>> obtenerHistorial(
            @Parameter(description = "ID del usuario", required = true, example = "1")
            @PathVariable Long usuarioId) {

        List<PagoResponseDTO> pagos = pagoService.listarPorUsuario(usuarioId);

        CollectionModel<PagoResponseDTO> model = CollectionModel.of(pagos);

        model.add(linkTo(methodOn(PagoController.class).obtenerHistorial(usuarioId)).withSelfRel());

        return ResponseEntity.ok(model);
    }

    @Operation(summary = "Registrar un nuevo pago")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pago registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<PagoResponseDTO> crearPago(@Valid @RequestBody PagoRequestDTO request) {
        return ResponseEntity.ok(pagoService.registrarPago(request));
    }
}