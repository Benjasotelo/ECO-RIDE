package com.ecoride.ms_viaje.repository;

import com.ecoride.ms_viaje.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    List<Viaje> findByPasajeroId(Long pasajeroId);
    List<Viaje> findByEstado(String estado);
}