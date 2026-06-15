package com.ecoride.ms_perfiles.repository;

import com.ecoride.ms_perfiles.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findByUsuarioId(Long usuarioId);
}