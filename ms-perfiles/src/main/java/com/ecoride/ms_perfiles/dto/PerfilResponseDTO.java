package com.ecoride.ms_perfiles.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilResponseDTO {
    private Long id;
    private Long usuarioId;
    private String nombreCompleto; // Podemos unir nombre y apellido aquí
    private String telefono;
    private String numeroLicencia;
    private LocalDate fechaNacimiento;
}