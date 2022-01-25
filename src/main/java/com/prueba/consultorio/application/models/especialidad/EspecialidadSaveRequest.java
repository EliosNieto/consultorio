package com.prueba.consultorio.application.models.especialidad;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class EspecialidadSaveRequest implements ApplicationRequest {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
