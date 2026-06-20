package com.ecoride.ms_precio.controller;

import io.swagger.v3.oas.annotations.Parameter;
import com.ecoride.ms_precio.dto.PrecioResponseDTO;
import com.ecoride.ms_precio.service.PrecioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Precios", description = "Operaciones relacionadas con cálculo de precios")
@RestController
@RequestMapping("/api/precios")
@RequiredArgsConstructor
public class PrecioController {

    private final PrecioService precioService;
    @Operation(summary = "Calcular precio de un viaje", description = "Calcula el precio final según tipo de vehículo y distancia en km")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Precio calculado correctamente"),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos")
    })
    @GetMapping("/calcular")
    public ResponseEntity<PrecioResponseDTO> calcular(
            @Parameter(description = "Tipo de vehículo", required = true, example = "AUTO")
            @RequestParam String tipo,
            @Parameter(description = "Distancia en kilómetros", required = true, example = "10.5")
            @RequestParam Double km) {
        return ResponseEntity.ok(precioService.calcularPrecioFinal(tipo, km));
    }
}