package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class CitaTipo {
    private NonEmptyUUID idCitaTipo;
    private NonEmptyString nombre;

    public CitaTipo(NonEmptyString nombre) {
        this.nombre = nombre;
    }

    public CitaTipo(NonEmptyUUID idCitaTipo, NonEmptyString nombre) {
        this.idCitaTipo = idCitaTipo;
        this.nombre = nombre;
    }

    public NonEmptyUUID getIdCitaTipo() {
        return idCitaTipo;
    }

    public void setIdCitaTipo(NonEmptyUUID idCitaTipo) {
        this.idCitaTipo = idCitaTipo;
    }

    public NonEmptyString getNombre() {
        return nombre;
    }

    public void setNombre(NonEmptyString nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CitaTipo{" +
                "idCitaTipo=" + idCitaTipo +
                ", nombre=" + nombre +
                '}';
    }
}
