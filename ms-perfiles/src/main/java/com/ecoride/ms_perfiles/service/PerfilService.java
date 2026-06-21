package com.ecoride.ms_perfiles.service;

import com.ecoride.ms_perfiles.dto.PerfilResponseDTO;
import com.ecoride.ms_perfiles.model.Perfil;
import com.ecoride.ms_perfiles.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public List<PerfilResponseDTO> listarTodos() {
        return perfilRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public PerfilResponseDTO obtenerPorUsuarioId(Long usuarioId) {
        Perfil perfil = perfilRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado para el usuario: " + usuarioId));
        return mapToDTO(perfil);
    }

    public PerfilResponseDTO guardar(Perfil perfil) {
        Perfil nuevoPerfil = perfilRepository.save(perfil);
        return mapToDTO(nuevoPerfil);
    }

    private PerfilResponseDTO mapToDTO(Perfil perfil) {
        String nombre = perfil.getNombre() != null ? perfil.getNombre() : "";
        String apellido = perfil.getApellido() != null ? perfil.getApellido() : "";
        String nombreCompleto = (nombre + " " + apellido).trim();

        return PerfilResponseDTO.builder()
                .id(perfil.getId())
                .usuarioId(perfil.getUsuarioId())
                .nombreCompleto(nombreCompleto.isEmpty() ? "Sin Nombre" : nombreCompleto)
                .telefono(perfil.getTelefono())
                .numeroLicencia(perfil.getNumeroLicencia())
                .fechaNacimiento(perfil.getFechaNacimiento())
                .build();
    }
}