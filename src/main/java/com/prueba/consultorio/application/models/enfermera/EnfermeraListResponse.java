package com.prueba.consultorio.application.models.enfermera;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Enfermera;

import java.util.List;

public class EnfermeraListResponse implements ApplicationResponse {

    private final List<Enfermera> enfermeras;

    public EnfermeraListResponse(List<Enfermera> enfermeras) {
        this.enfermeras = enfermeras;
    }

    public List<Enfermera> getEnfermeras() {
        return enfermeras;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
