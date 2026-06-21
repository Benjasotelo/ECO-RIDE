package com.ecoride.ms_usuario.assembler;

import com.ecoride.ms_usuario.controller.UsuarioController;
import com.ecoride.ms_usuario.dto.UsuarioResponseDTO;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<UsuarioResponseDTO, UsuarioResponseDTO> {

    @Override
    public UsuarioResponseDTO toModel(UsuarioResponseDTO usuario) {
        usuario.add(linkTo(methodOn(UsuarioController.class).buscarPorId(usuario.getId())).withSelfRel());
        usuario.add(linkTo(methodOn(UsuarioController.class).listar()).withRel("usuarios"));
        return usuario;
    }
}