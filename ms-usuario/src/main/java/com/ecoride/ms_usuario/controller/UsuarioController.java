package com.ecoride.ms_usuario.controller;

import com.ecoride.ms_usuario.assembler.UsuarioModelAssembler;
import com.ecoride.ms_usuario.dto.UsuarioResponseDTO;
import com.ecoride.ms_usuario.model.Usuario;
import com.ecoride.ms_usuario.service.UsuarioService;
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

@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioModelAssembler assembler;

    @Operation(summary = "Listar todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<CollectionModel<UsuarioResponseDTO>> listar() {
        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(usuarios));
    }

    @Operation(summary = "Obtener usuario por ID", description = "Retorna un usuario específico según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(
            @Parameter(description = "ID del usuario", required = true, example = "1")
            @PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.obtenerPorId(id);
        return ResponseEntity.ok(assembler.toModel(usuario));
    }

    @Operation(summary = "Crear nuevo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crear(@RequestBody Usuario usuario) {
        UsuarioResponseDTO creado = usuarioService.guardar(usuario);
        return ResponseEntity.ok(assembler.toModel(creado));
    }
}