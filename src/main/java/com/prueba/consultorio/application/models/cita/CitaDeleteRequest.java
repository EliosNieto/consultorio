package com.prueba.consultorio.application.models.cita;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class CitaDeleteRequest implements ApplicationRequest {
    private final String id;

    public CitaDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
