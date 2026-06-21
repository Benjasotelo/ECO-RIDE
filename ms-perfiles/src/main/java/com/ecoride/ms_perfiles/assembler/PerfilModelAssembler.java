/*package com.ecoride.ms_perfiles.assembler;

import com.ecoride.ms_perfiles.controller.PerfilController;
import com.ecoride.ms_perfiles.dto.PerfilResponseDTO;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PerfilModelAssembler implements RepresentationModelAssembler<PerfilResponseDTO, PerfilResponseDTO> {

    @Override
    public PerfilResponseDTO toModel(PerfilResponseDTO perfil) {
        perfil.add(linkTo(methodOn(PerfilController.class).obtenerPorUsuario(perfil.getUsuarioId())).withSelfRel());
        perfil.add(linkTo(methodOn(PerfilController.class).listar()).withRel("perfiles"));
        return perfil;
    }
}*/