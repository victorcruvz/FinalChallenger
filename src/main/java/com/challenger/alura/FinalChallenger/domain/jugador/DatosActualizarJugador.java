package com.challenger.alura.FinalChallenger.domain.jugador;

import com.challenger.alura.FinalChallenger.domain.tipocuenta.DatosTipoCuenta;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarJugador(
        @NotNull Long id,
        String nombre,
        DatosTipoCuenta tipoCuenta
) {
}