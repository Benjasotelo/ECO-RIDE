package com.ecoride.ms_perfiles.controller;

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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Perfiles", description = "Operaciones relacionadas con perfiles de usuario")
@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;

    @Operation(summary = "Listar todos los perfiles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<CollectionModel<PerfilResponseDTO>> listar() {
        List<PerfilResponseDTO> perfiles = perfilService.listarTodos();
        CollectionModel<PerfilResponseDTO> model = CollectionModel.of(perfiles);
        model.add(linkTo(methodOn(PerfilController.class).listar()).withSelfRel());
        return ResponseEntity.ok(model);
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
        perfil.add(linkTo(methodOn(PerfilController.class).obtenerPorUsuario(usuarioId)).withSelfRel());
        return ResponseEntity.ok(perfil);
    }

    @Operation(summary = "Crear un nuevo perfil")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<PerfilResponseDTO> crear(@RequestBody Perfil perfil) {
        PerfilResponseDTO creado = perfilService.guardar(perfil);
        creado.add(linkTo(methodOn(PerfilController.class).obtenerPorUsuario(creado.getUsuarioId())).withSelfRel());
        return ResponseEntity.ok(creado);
    }
}