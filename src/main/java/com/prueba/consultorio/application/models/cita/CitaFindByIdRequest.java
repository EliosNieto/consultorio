package com.prueba.consultorio.application.models.cita;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class CitaFindByIdRequest implements ApplicationRequest {
    private final String id;

    public CitaFindByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
