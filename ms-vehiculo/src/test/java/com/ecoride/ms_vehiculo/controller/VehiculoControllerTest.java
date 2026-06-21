package com.ecoride.ms_vehiculo.controller;

import com.ecoride.ms_vehiculo.assembler.VehiculoModelAssembler;
import com.ecoride.ms_vehiculo.dto.VehiculoResponseDTO;
import com.ecoride.ms_vehiculo.service.VehiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(VehiculoController.class)
public class VehiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VehiculoService vehiculoService;

    @MockitoBean
    private VehiculoModelAssembler assembler;

    private VehiculoResponseDTO vehiculoMock;

    @BeforeEach
    void setUp() {

        vehiculoMock = VehiculoResponseDTO.builder()
                .id(1L)
                .placa("ABC123")
                .tipo("AUTO")
                .estado("DISPONIBLE")
                .build();
    }

    @Test
    void obtenerDisponibles_DeberiaRetornarColeccionHalJsonYStatus200() throws Exception {
        Mockito.when(vehiculoService.listarDisponibles()).thenReturn(List.of(vehiculoMock));
        Mockito.when(assembler.toModel(Mockito.any(VehiculoResponseDTO.class))).thenReturn(vehiculoMock);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/vehiculos/disponibles")
                        .accept(MediaTypes.HAL_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.vehiculoResponseDTOList[0].placa").value("ABC123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.vehiculoResponseDTOList[0].tipo").value("AUTO"));
                //.andExpect(MockMvcResultMatchers.jsonPath("$._links.self.href").exists());
    }
}