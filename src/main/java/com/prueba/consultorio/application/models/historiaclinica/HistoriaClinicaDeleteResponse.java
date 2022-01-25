package com.prueba.consultorio.application.models.historiaclinica;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.HistoriaClinica;

import java.util.UUID;

public class HistoriaClinicaDeleteResponse implements ApplicationResponse {

    private final UUID id;

    public HistoriaClinicaDeleteResponse(UUID id) {
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
