package com.ecoride.ms_vehiculo.assembler;

import com.ecoride.ms_vehiculo.controller.VehiculoController;
import com.ecoride.ms_vehiculo.dto.VehiculoResponseDTO;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class VehiculoModelAssembler implements RepresentationModelAssembler<VehiculoResponseDTO, VehiculoResponseDTO> {

    @Override
    public VehiculoResponseDTO toModel(VehiculoResponseDTO vehiculo) {
        vehiculo.add(linkTo(methodOn(VehiculoController.class).buscarPorId(vehiculo.getId())).withSelfRel());
        vehiculo.add(linkTo(methodOn(VehiculoController.class).obtenerDisponibles()).withRel("vehiculos-disponibles"));
        return vehiculo;
    }
}