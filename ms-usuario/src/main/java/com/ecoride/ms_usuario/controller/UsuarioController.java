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
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder; // Importante para el link auto-referenciado
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
@RestController
@RequestMapping("/api/v1/usuarios") // 1. CORREGIDO: Agregamos el /v1 para que calce con el Gateway
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
        // 2. CORREGIDO: Obtenemos los DTOs directos del servicio
        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos();

        // Mapeamos cada uno individualmente a través del assembler para inyectarles sus links /id
        usuarios.forEach(assembler::toModel);

        // Creamos el CollectionModel raíz y le inyectamos el link de este mismo método
        CollectionModel<UsuarioResponseDTO> model = CollectionModel.of(usuarios);
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).listar()).withSelfRel());

        return ResponseEntity.ok(model);
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