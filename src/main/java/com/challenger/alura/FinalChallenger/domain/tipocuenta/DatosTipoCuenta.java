package com.challenger.alura.FinalChallenger.domain.tipocuenta;

import jakarta.validation.constraints.NotBlank;

public record DatosTipoCuenta(
        @NotBlank String fechaCreacion,
        @NotBlank String equipo,
        @NotBlank String region
) {
}