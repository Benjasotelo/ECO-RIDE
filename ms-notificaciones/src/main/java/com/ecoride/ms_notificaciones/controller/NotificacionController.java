package com.ecoride.ms_notificaciones.controller;

import com.ecoride.ms_notificaciones.dto.NotificacionRequestDTO;
import com.ecoride.ms_notificaciones.dto.NotificacionResponseDTO;
import com.ecoride.ms_notificaciones.service.NotificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Notificaciones", description = "Operaciones relacionadas con notificaciones")
@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @Operation(summary = "Enviar una notificación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificación enviada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<NotificacionResponseDTO> enviar(@Valid @RequestBody NotificacionRequestDTO request) {
        return ResponseEntity.ok(notificacionService.registrarYEnviar(request));
    }

    @Operation(summary = "Obtener historial de notificaciones por usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Historial obtenido correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CollectionModel<NotificacionResponseDTO>> historial(
            @Parameter(description = "ID del usuario", required = true, example = "1")
            @PathVariable Long usuarioId) {

        List<NotificacionResponseDTO> notificaciones = notificacionService.listarPorUsuario(usuarioId);
        CollectionModel<NotificacionResponseDTO> model = CollectionModel.of(notificaciones);
        model.add(linkTo(methodOn(NotificacionController.class).historial(usuarioId)).withSelfRel());

        return ResponseEntity.ok(model);
    }
}