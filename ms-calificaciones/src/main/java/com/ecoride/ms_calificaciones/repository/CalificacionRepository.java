package com.ecoride.ms_calificaciones.repository;

import com.ecoride.ms_calificaciones.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findByReceptorId(Long receptorId);
}