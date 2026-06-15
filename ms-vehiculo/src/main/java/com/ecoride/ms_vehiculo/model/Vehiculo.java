package com.ecoride.ms_vehiculo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La patente o ID de serie es obligatoria")
    private String placa;

    @NotBlank(message = "El tipo de vehículo es obligatorio")
    private String tipo;

    private String modelo;
    private String estado;
    private Double nivelBateria;
}