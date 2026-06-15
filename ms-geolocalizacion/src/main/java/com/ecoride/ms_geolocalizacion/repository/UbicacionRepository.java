package com.ecoride.ms_geolocalizacion.repository;

import com.ecoride.ms_geolocalizacion.model.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
    Optional<Ubicacion> findByVehiculoId(Long vehiculoId);
}