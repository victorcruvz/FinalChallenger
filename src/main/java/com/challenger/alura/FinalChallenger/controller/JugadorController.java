package com.challenger.alura.FinalChallenger.controller;

import com.challenger.alura.FinalChallenger.domain.jugador.*;
import com.challenger.alura.FinalChallenger.domain.tipocuenta.DatosTipoCuenta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorReposiory jugadorRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaJugador> registrarJugador(@RequestBody @Valid DatosRegistrJugador datosRegistrJugador,
                                                                 UriComponentsBuilder uriComponentsBuilder){
        Jugador jugador = jugadorRepository.save(new Jugador(datosRegistrJugador));
        DatosRespuestaJugador datosRespuestaJugador = new DatosRespuestaJugador(
                jugador.getId(), jugador.getNombre(), jugador.getEmail(),
                jugador.getFechaNacimiento(), jugador.getRango().toString(),
                new DatosTipoCuenta(jugador.getTipoCuenta().getFechaCreacion(),
                        jugador.getTipoCuenta().getEquipo(),
                        jugador.getTipoCuenta().getRegion())
        );

        URI url = uriComponentsBuilder.path("/jugadores/{id}").buildAndExpand(jugador.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaJugador);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoJugador>> listadoJugador(/*@PageableDefault(size = 2)*/ Pageable paginacion){
        return ResponseEntity.ok(jugadorRepository.findByActivoTrue(paginacion)
                .map(DatosListadoJugador::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarJugador(@RequestBody @Valid DatosActualizarJugador datosActualizarJugador){
        Jugador jugador = jugadorRepository.getReferenceById(datosActualizarJugador.id());
        jugador.actualizarDatos(datosActualizarJugador);
        return ResponseEntity.ok(new DatosRespuestaJugador(
                jugador.getId(), jugador.getNombre(), jugador.getEmail(),
                jugador.getFechaNacimiento(), jugador.getRango().toString(),
                new DatosTipoCuenta(jugador.getTipoCuenta().getFechaCreacion(),jugador.getTipoCuenta().getEquipo(),jugador.getTipoCuenta().getRegion())
        ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    //DELETE LOGICO
    public ResponseEntity eliminarJugador(@PathVariable Long id){
        Jugador jugador = jugadorRepository.getReferenceById(id);
        jugador.desactivarJugador();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    //DELETE LOGICO
    public ResponseEntity<DatosRespuestaJugador> retornaDatosJugador(@PathVariable Long id){
        Jugador jugador = jugadorRepository.getReferenceById(id);
        val datosJugador = new DatosRespuestaJugador(jugador.getId(), jugador.getNombre(), jugador.getEmail(),
                jugador.getFechaNacimiento(), jugador.getRango().toString(),
                new DatosTipoCuenta(jugador.getTipoCuenta().getFechaCreacion(),jugador.getTipoCuenta().getEquipo(),jugador.getTipoCuenta().getRegion())
        );
        return ResponseEntity.ok(datosJugador);
    }
}
