package com.challenger.alura.FinalChallenger.domain.jugador;

import com.challenger.alura.FinalChallenger.domain.tipocuenta.DatosTipoCuenta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrJugador(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String fechaNacimiento,
        @NotNull Rango rango,
        @NotNull @Valid DatosTipoCuenta tipoCuenta
) {
}