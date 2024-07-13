package com.challenger.alura.FinalChallenger.domain.jugador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorReposiory extends JpaRepository<Jugador,Long> {
    Page<Jugador> findByActivoTrue(Pageable paginacion);
}
