package com.prueba.consultorio.application.models.especialidad;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;

import java.util.UUID;

public class EspecialidadDeleteResponse implements ApplicationResponse {

    private final UUID id;

    public EspecialidadDeleteResponse(UUID id) {
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
