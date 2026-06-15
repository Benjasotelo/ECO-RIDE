package com.ecoride.ms_perfiles.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PerfilRequestDTO {
    private Long usuarioId;
    private String nombre;
    private String apellido;
    private String telefono;
    private String numeroLicencia;
    private LocalDate fechaNacimiento;
}