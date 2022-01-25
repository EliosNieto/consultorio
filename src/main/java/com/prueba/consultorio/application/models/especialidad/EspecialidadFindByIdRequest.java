package com.prueba.consultorio.application.models.especialidad;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class EspecialidadFindByIdRequest implements ApplicationRequest {

    private final String id;

    public EspecialidadFindByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

