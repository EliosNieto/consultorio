package com.prueba.consultorio.application.models.examenclinico;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;

import java.util.UUID;

public class ExamenClinicoDeleteResponse implements ApplicationResponse {

    private final UUID id;

    public ExamenClinicoDeleteResponse(UUID id) {
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
