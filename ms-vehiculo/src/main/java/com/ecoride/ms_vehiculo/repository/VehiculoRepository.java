package com.ecoride.ms_vehiculo.repository;

import com.ecoride.ms_vehiculo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByEstado(String estado);
    List<Vehiculo> findByTipo(String tipo);
}