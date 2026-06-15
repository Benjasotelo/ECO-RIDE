package com.ecoride.ms_perfiles.controller;

import com.ecoride.ms_perfiles.dto.PerfilRequestDTO;
import com.ecoride.ms_perfiles.dto.PerfilResponseDTO;
import com.ecoride.ms_perfiles.model.Perfil;
import com.ecoride.ms_perfiles.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;


    @GetMapping
    public ResponseEntity<List<PerfilResponseDTO>> listar() {
        return ResponseEntity.ok(perfilService.listarTodos());
    }


    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<PerfilResponseDTO> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(perfilService.obtenerPorUsuarioId(usuarioId));
    }


    @PostMapping
    public ResponseEntity<PerfilResponseDTO> crear(@RequestBody Perfil perfil) {
        // Nota: Aquí podrías usar PerfilRequestDTO si prefieres separar la entrada
        return ResponseEntity.ok(perfilService.guardar(perfil));
    }
}