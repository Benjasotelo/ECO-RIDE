package com.ecoride.ms_geolocalizacion.controller;

import com.ecoride.ms_geolocalizacion.dto.UbicacionRequestDTO;
import com.ecoride.ms_geolocalizacion.dto.UbicacionResponseDTO;
import com.ecoride.ms_geolocalizacion.service.UbicacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Geolocalización", description = "Operaciones relacionadas con ubicación de vehículos")
@RestController
@RequestMapping("/api/ubicaciones")
@RequiredArgsConstructor
public class UbicacionController {

    private final UbicacionService ubicacionService;
    @Operation(summary = "Actualizar ubicación de un vehículo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ubicación actualizada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping("/actualizar")
    public ResponseEntity<UbicacionResponseDTO> actualizar(@Valid @RequestBody UbicacionRequestDTO request) {
        return ResponseEntity.ok(ubicacionService.actualizarUbicacion(request));
    }

    @Operation(summary = "Obtener ubicación de un vehículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ubicación encontrada"),
            @ApiResponse(responseCode = "404", description = "Vehículo no encontrado")
    })
    @GetMapping("/vehiculo/{id}")
    public ResponseEntity<UbicacionResponseDTO> obtener(
            @Parameter(description = "ID del vehículo", required = true, example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(ubicacionService.obtenerPorVehiculo(id));
    }
}