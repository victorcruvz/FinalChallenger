package com.challenger.alura.FinalChallenger.domain.jugador;

public record DatosListadoJugador(
        Long id,
        String nombre,
        String rango,
        String email
) {
    public DatosListadoJugador(Jugador jugador){
        this(jugador.getId(), jugador.getNombre(), jugador.getRango().toString(), jugador.getEmail());
    }
}
