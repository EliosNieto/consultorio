package com.prueba.consultorio.application.models.control;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Control;

import java.util.UUID;

public class ControlDeleteResponse implements ApplicationResponse {

    private final UUID uuid;

    public ControlDeleteResponse(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.NOT_CONTENT;
    }
}
