package com.challenger.alura.FinalChallenger.domain.tipocuenta;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCuenta {

    private String fechaCreacion;
    private String equipo;
    private String region;

    public TipoCuenta(DatosTipoCuenta tipoCuenta){
        this.fechaCreacion= tipoCuenta.fechaCreacion();
        this.equipo= tipoCuenta.equipo();
        this.region=tipoCuenta.region();
    }

    public TipoCuenta actualizarDatos(DatosTipoCuenta tipoCuenta){
        this.fechaCreacion= tipoCuenta.fechaCreacion();
        this.equipo= tipoCuenta.equipo();
        this.region= tipoCuenta.region();
        return this;
    }
}
