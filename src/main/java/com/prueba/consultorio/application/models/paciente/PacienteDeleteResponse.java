package com.prueba.consultorio.application.models.paciente;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Paciente;

import java.util.UUID;

public class PacienteDeleteResponse implements ApplicationResponse {

    private final UUID id;

    public PacienteDeleteResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.NOT_CONTENT;
    }
}
