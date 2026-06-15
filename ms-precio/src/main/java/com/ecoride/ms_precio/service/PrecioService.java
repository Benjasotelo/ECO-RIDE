package com.ecoride.ms_precio.service;

import com.ecoride.ms_precio.dto.PrecioResponseDTO;
import com.ecoride.ms_precio.model.Precio;
import com.ecoride.ms_precio.repository.PrecioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrecioService {
    private final PrecioRepository precioRepository;

    public PrecioResponseDTO calcularPrecioFinal(String tipo, Double km) {
        Precio precio = precioRepository.findByTipoVehiculo(tipo)
                .orElseThrow(() -> new RuntimeException("Configuración de precio no encontrada para: " + tipo));

        Double total = precio.getValorBase() + (precio.getValorPorKilometro() * km);

        return PrecioResponseDTO.builder()
                .tipoVehiculo(tipo)
                .precioTotal(total)
                .distanciaKm(km)
                .build();
    }
}