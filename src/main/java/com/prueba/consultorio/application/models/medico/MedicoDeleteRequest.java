package com.prueba.consultorio.application.models.medico;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class MedicoDeleteRequest implements ApplicationRequest {

    private final String id;

    public MedicoDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
