package com.ecoride.ms_viaje.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del pasajero es obligatorio")
    private Long pasajeroId;

    private Long conductorId; // Puede ser nulo al inicio hasta que alguien acepte

    @NotBlank(message = "El origen es obligatorio")
    private String origen;

    @NotBlank(message = "El destino es obligatorio")
    private String destino;

    private Double distanciaKm;
    private Double costoTotal;

    private String estado;
    private LocalDateTime fechaInicio;
    private String tipoVehiculo;
}