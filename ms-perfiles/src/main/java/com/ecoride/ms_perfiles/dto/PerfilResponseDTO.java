package com.ecoride.ms_perfiles.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Respuesta con datos del perfil")
public class PerfilResponseDTO {
    @Schema(description = "ID del perfil", example = "1")
    private Long id;
    @Schema(description = "ID del usuario asociado", example = "1")
    private Long usuarioId;
    @Schema(description = "Nombre completo", example = "Juan Pérez")
    private String nombreCompleto;
    @Schema(description = "Teléfono de contacto", example = "+56912345678")
    private String telefono;
    @Schema(description = "Número de licencia", example = "LIC-123456")
    private String numeroLicencia;
    @Schema(description = "Fecha de nacimiento", example = "1990-05-20")
    private LocalDate fechaNacimiento;
}