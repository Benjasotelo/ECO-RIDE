package com.ecoride.ms_perfiles.controller;

import com.ecoride.ms_perfiles.dto.PerfilRequestDTO;
import com.ecoride.ms_perfiles.dto.PerfilResponseDTO;
import com.ecoride.ms_perfiles.model.Perfil;
import com.ecoride.ms_perfiles.service.PerfilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Perfiles", description = "Operaciones relacionadas con perfiles de usuario")
@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    @Operation(summary = "Listar todos los perfiles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<PerfilResponseDTO>> listar() {
        return ResponseEntity.ok(perfilService.listarTodos());
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
        return ResponseEntity.ok(perfilService.obtenerPorUsuarioId(usuarioId));
    }

    @Operation(summary = "Crear un nuevo perfil")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<PerfilResponseDTO> crear(@RequestBody Perfil perfil) {
        return ResponseEntity.ok(perfilService.guardar(perfil));
    }
}

    @PostMapping
    public ResponseEntity<PerfilResponseDTO> crear(@RequestBody Perfil perfil) {
        // Nota: Aquí podrías usar PerfilRequestDTO si prefieres separar la entrada
        return ResponseEntity.ok(perfilService.guardar(perfil));
    }
}