package com.ecoride.ms_usuario.service;

import com.ecoride.ms_usuario.dto.UsuarioResponseDTO;
import com.ecoride.ms_usuario.model.Usuario;
import com.ecoride.ms_usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO guardar(Usuario usuario) {
        usuario.setActivo(true);
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return mapToDTO(nuevoUsuario);
    }

    public UsuarioResponseDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapToDTO(usuario);
    }

    private UsuarioResponseDTO mapToDTO(Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .correoElectronico(usuario.getCorreoElectronico())
                .rol(usuario.getRol())
                .activo(usuario.getActivo())
                .build();
    }
}