package com.ecoride.ms_viaje.clients;

import com.ecoride.ms_viaje.dto.VehiculoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-vehiculo", url = "localhost:8083")
public interface VehiculoClient {
    @GetMapping("/api/vehiculos/{id}")
    VehiculoDTO obtenerPorId(@PathVariable("id") Long id);
}

