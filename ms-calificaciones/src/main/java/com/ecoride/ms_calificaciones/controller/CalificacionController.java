package com.ecoride.ms_calificaciones.controller;

import com.ecoride.ms_calificaciones.dto.CalificacionRequestDTO;
import com.ecoride.ms_calificaciones.dto.CalificacionResponseDTO;
import com.ecoride.ms_calificaciones.service.CalificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(name = "Calificaciones", description = "Operaciones relacionadas con calificaciones")
@RestController
@RequestMapping("/api/calificaciones")
@RequiredArgsConstructor
public class CalificacionController {
    private final CalificacionService calificacionService;
    @Operation(summary = "Crear una nueva calificación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Calificación creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<CalificacionResponseDTO> crear(@Valid @RequestBody CalificacionRequestDTO request) {
        return ResponseEntity.ok(calificacionService.crearCalificacion(request));
    }

    @Operation(summary = "Listar calificaciones por usuario receptor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/receptor/{id}")
    public ResponseEntity<List<CalificacionResponseDTO>> listar(
            @Parameter(description = "ID del usuario receptor", required = true, example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(calificacionService.obtenerPorUsuario(id));
    }
}