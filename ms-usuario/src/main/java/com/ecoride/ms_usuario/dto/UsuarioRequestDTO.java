package com.ecoride.ms_usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private String nombreUsuario;
    private String correoElectronico;
    private String contrasena;
    private String rol;
}