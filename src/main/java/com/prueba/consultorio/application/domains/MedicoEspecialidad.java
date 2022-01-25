package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class MedicoEspecialidad {
    private NonEmptyUUID id;
    private NonEmptyString nombres;

    public MedicoEspecialidad(NonEmptyString nombres) {
        this.nombres = nombres;
    }

    public MedicoEspecialidad(NonEmptyUUID id, NonEmptyString nombres) {
        this.id = id;
        this.nombres = nombres;
    }

    public NonEmptyUUID getId() {
        return id;
    }

    public void setId(NonEmptyUUID id) {
        this.id = id;
    }

    public NonEmptyString getNombres() {
        return nombres;
    }

    public void setNombres(NonEmptyString nombres) {
        this.nombres = nombres;
    }
    @Override
    public String toString() {
        return "MedicoEspecialidad{" +
                "id=" + id +
                ", nombres=" + nombres +
                '}';
    }
}
