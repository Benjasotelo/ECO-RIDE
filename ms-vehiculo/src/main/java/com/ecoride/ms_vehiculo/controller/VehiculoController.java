package com.ecoride.ms_vehiculo.controller;

import com.ecoride.ms_vehiculo.dto.VehiculoRequestDTO;
import com.ecoride.ms_vehiculo.dto.VehiculoResponseDTO;
import com.ecoride.ms_vehiculo.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Vehículos", description = "Operaciones relacionadas con vehículos")
@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;
    @Operation(summary = "Listar vehículos disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping("/disponibles")
    public ResponseEntity<List<VehiculoResponseDTO>> obtenerDisponibles() {
        return ResponseEntity.ok(vehiculoService.listarDisponibles());
    }

    @Operation(summary = "Registrar un nuevo vehículo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehículo registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<VehiculoResponseDTO> guardar(@Valid @RequestBody VehiculoRequestDTO request) {
        return ResponseEntity.ok(vehiculoService.registrar(request));
    }
}