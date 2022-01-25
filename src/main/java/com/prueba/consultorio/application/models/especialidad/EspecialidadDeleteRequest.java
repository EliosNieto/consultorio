package com.prueba.consultorio.application.models.especialidad;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class EspecialidadDeleteRequest implements ApplicationRequest {

    private final String id;

    public EspecialidadDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

