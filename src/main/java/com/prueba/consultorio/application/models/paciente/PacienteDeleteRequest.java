package com.prueba.consultorio.application.models.paciente;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class PacienteDeleteRequest implements ApplicationRequest {
    private final String id;

    public PacienteDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
