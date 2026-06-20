package com.ecoride.ms_mantenimiento.controller;

import com.ecoride.ms_mantenimiento.dto.MantenimientoRequestDTO;
import com.ecoride.ms_mantenimiento.dto.MantenimientoResponseDTO;
import com.ecoride.ms_mantenimiento.service.MantenimientoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Mantenimiento", description = "Operaciones relacionadas con mantenimiento de vehículos")
@RestController
@RequestMapping("/api/mantenimientos")
@RequiredArgsConstructor
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    @Operation(summary = "Registrar ingreso a mantenimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ingreso registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<MantenimientoResponseDTO> ingresar(@Valid @RequestBody MantenimientoRequestDTO request) {
        return ResponseEntity.ok(mantenimientoService.registrarIngreso(request));
    }

    @Operation(summary = "Listar mantenimientos activos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping("/activos")
    public ResponseEntity<List<MantenimientoResponseDTO>> obtenerActivos() {
        return ResponseEntity.ok(mantenimientoService.listarActivos());
    }
}