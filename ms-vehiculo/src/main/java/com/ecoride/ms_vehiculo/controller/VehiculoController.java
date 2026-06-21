package com.ecoride.ms_vehiculo.controller;

import com.ecoride.ms_vehiculo.assembler.VehiculoModelAssembler;
import com.ecoride.ms_vehiculo.dto.VehiculoRequestDTO;
import com.ecoride.ms_vehiculo.dto.VehiculoResponseDTO;
import com.ecoride.ms_vehiculo.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Vehículos", description = "Operaciones relacionadas con vehículos")
@RestController
@RequestMapping("/api/v1/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;
    private final VehiculoModelAssembler assembler;

    @Operation(summary = "Listar vehículos disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping("/disponibles")
    public ResponseEntity<CollectionModel<VehiculoResponseDTO>> obtenerDisponibles() {
        List<VehiculoResponseDTO> vehiculos = vehiculoService.listarDisponibles().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(vehiculos));
    }

    @Operation(summary = "Obtener vehículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehículo encontrado"),
            @ApiResponse(responseCode = "404", description = "Vehículo no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoResponseDTO> buscarPorId(
            @Parameter(description = "ID del vehículo", required = true, example = "1")
            @PathVariable Long id) {
        VehiculoResponseDTO vehiculo = vehiculoService.obtenerPorId(id);
        return ResponseEntity.ok(assembler.toModel(vehiculo));
    }

    @Operation(summary = "Registrar un nuevo vehículo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehículo registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<VehiculoResponseDTO> guardar(@Valid @RequestBody VehiculoRequestDTO request) {
        VehiculoResponseDTO creado = vehiculoService.registrar(request);
        return ResponseEntity.ok(assembler.toModel(creado));
    }
}