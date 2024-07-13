package com.challenger.alura.FinalChallenger.domain.jugador;

import com.challenger.alura.FinalChallenger.domain.tipocuenta.TipoCuenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="jugadores")
@Entity(name = "Jugador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private Boolean activo;
    private String fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private Rango rango;
    @Embedded
    private TipoCuenta tipoCuenta;

    public Jugador(DatosRegistrJugador datosRegistrJugador){
        this.activo=true;
        this.nombre=datosRegistrJugador.nombre();
        this.email=datosRegistrJugador.email();
        this.fechaNacimiento=datosRegistrJugador.fechaNacimiento();
        this.rango=datosRegistrJugador.rango();
        this.tipoCuenta=new TipoCuenta(datosRegistrJugador.tipoCuenta());
    }

    public void actualizarDatos(DatosActualizarJugador datosActualizarJugador){
        if (datosActualizarJugador.nombre()!=null){
            this.nombre= datosActualizarJugador.nombre();
        }
        if (datosActualizarJugador.tipoCuenta()!=null){
            this.tipoCuenta=tipoCuenta.actualizarDatos(datosActualizarJugador.tipoCuenta());
        }
    }

    public void desactivarJugador(){
        this.activo=false;
    }
}
