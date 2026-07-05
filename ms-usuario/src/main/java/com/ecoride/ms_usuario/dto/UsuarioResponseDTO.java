package com.ecoride.ms_usuario.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Schema(description = "Respuesta con datos del usuario")
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDTO extends RepresentationModel<UsuarioResponseDTO> {

    @Schema(description = "ID del usuario", example = "1")
    private Long id;

    @Schema(description = "Nombre de usuario", example = "victor_admin")
    private String nombreUsuario;

    @Schema(description = "Correo electrónico", example = "victor@ecoride.cl")
    private String correoElectronico;

    @Schema(description = "Rol del usuario", example = "ADMIN")
    private String rol;

    @Schema(description = "Estado activo del usuario", example = "true")
    private Boolean activo;
}