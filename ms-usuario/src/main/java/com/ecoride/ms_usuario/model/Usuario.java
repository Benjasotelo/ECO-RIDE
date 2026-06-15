package com.ecoride.ms_usuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombreUsuario;

    @Column(unique = true, nullable = false)
    private String correoElectronico;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String rol; // ADMIN, CONDUCTOR, PASAJERO

    private Boolean activo;
}