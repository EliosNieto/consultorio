package com.prueba.consultorio.application.models.enfermera;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Enfermera;

import java.util.List;
import java.util.UUID;

public class EnfermeraDeleteResponse implements ApplicationResponse {

    private UUID uuid;

    public EnfermeraDeleteResponse(UUID uuid) {
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
