package com.ecoride.ms_precio.repository;

import com.ecoride.ms_precio.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long> {
    Optional<Precio> findByTipoVehiculo(String tipoVehiculo);
}