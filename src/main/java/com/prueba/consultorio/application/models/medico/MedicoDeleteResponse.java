package com.prueba.consultorio.application.models.medico;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;

import java.util.UUID;

public class MedicoDeleteResponse implements ApplicationResponse {

    private final UUID id;

    public MedicoDeleteResponse(UUID id) {
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
