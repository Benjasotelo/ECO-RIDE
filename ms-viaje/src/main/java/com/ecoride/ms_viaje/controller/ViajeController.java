package com.ecoride.ms_viaje.controller;

import com.ecoride.ms_viaje.dto.ViajeRequestDTO;
import com.ecoride.ms_viaje.dto.ViajeResponseDTO;
import com.ecoride.ms_viaje.service.ViajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Viajes", description = "Operaciones relacionadas con viajes")
@RestController
@RequestMapping("/api/viajes")
@RequiredArgsConstructor
public class ViajeController {

    private final ViajeService viajeService;
    @Operation(summary = "Solicitar un nuevo viaje")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Viaje creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<ViajeResponseDTO> solicitarViaje(@Valid @RequestBody ViajeRequestDTO request) {
        return ResponseEntity.ok(viajeService.crearViaje(request));
    }

    @Operation(summary = "Listar viajes activos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping("/activos")
    public ResponseEntity<List<ViajeResponseDTO>> obtenerActivos() {
        return ResponseEntity.ok(viajeService.listarViajesActivos());
    }
}