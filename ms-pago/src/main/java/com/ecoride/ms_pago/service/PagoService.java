package com.ecoride.ms_pago.service;

import com.ecoride.ms_pagos.dto.PagoRequestDTO;
import com.ecoride.ms_pago.dto.PagoResponseDTO;
import com.ecoride.ms_pago.model.Pago;
import com.ecoride.ms_pago.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;


    public List<PagoResponseDTO> listarPorUsuario(Long usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    public PagoResponseDTO registrarPago(PagoRequestDTO request) {
        // 1. Convertimos RequestDTO -> Entidad (Model)
        Pago pago = new Pago();
        pago.setUsuarioId(request.getUsuarioId());
        pago.setMonto(request.getMonto());
        pago.setMetodoPago(request.getMetodoPago());

        // 2. Agregamos datos que el usuario no envía
        pago.setFecha(LocalDateTime.now());
        pago.setEstado("COMPLETADO");


        Pago guardado = pagoRepository.save(pago);

        // 4. Devolvemos ResponseDTO
        return mapToDTO(guardado);
    }


    private PagoResponseDTO mapToDTO(Pago pago) {
        return PagoResponseDTO.builder()
                .id(pago.getId())
                .usuarioId(pago.getUsuarioId())
                .monto(pago.getMonto())
                .estado(pago.getEstado())
                .fecha(pago.getFecha())
                .build();
    }
}