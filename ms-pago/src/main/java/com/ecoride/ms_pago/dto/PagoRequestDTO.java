package com.ecoride.ms_pagos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PagoRequestDTO {

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a cero")
    private Double monto;

    @NotNull(message = "El método de pago es obligatorio")
    private String metodoPago; // DEBITO, CREDITO, etc.
}