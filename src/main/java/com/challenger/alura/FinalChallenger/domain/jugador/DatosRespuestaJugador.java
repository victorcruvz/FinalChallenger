package com.challenger.alura.FinalChallenger.domain.jugador;

import com.challenger.alura.FinalChallenger.domain.tipocuenta.DatosTipoCuenta;

public record DatosRespuestaJugador(
        Long id,
        String nombre,
        String email,
        String fechaNacimiento,
        String rango,
        DatosTipoCuenta tipoCuenta
) {
}
