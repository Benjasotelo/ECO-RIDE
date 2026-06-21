package com.ecoride.ms_perfiles.controller;

import com.ecoride.ms_perfiles.assembler.PerfilModelAssembler;
import com.ecoride.ms_perfiles.dto.PerfilResponseDTO;
import com.ecoride.ms_perfiles.model.Perfil;
import com.ecoride.ms_perfiles.service.PerfilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Perfiles", description = "Operaciones relacionadas con perfiles de usuario")
@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;
    private final PerfilModelAssembler assembler;

    @Operation(summary = "Listar todos los perfiles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<CollectionModel<PerfilResponseDTO>> listar() {
        List<PerfilResponseDTO> perfiles = perfilService.listarTodos().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(perfiles));
    }

    @Operation(summary = "Obtener perfil por ID de usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil encontrado"),
            @ApiResponse(responseCode = "404", description = "Perfil no encontrado")
    })
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<PerfilResponseDTO> obtenerPorUsuario(
            @Parameter(description = "ID del usuario", required = true, example = "1")
            @PathVariable Long usuarioId) {
        PerfilResponseDTO perfil = perfilService.obtenerPorUsuarioId(usuarioId);
        return ResponseEntity.ok(assembler.toModel(perfil));
    }

    @Operation(summary = "Crear un nuevo perfil")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<PerfilResponseDTO> crear(@RequestBody Perfil perfil) {
        PerfilResponseDTO creado = perfilService.guardar(perfil);
        return ResponseEntity.ok(assembler.toModel(creado));
    }
}