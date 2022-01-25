package com.prueba.consultorio.application.models.examenclinico;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.ExamenClinico;

public class ExamenClinicoFindByIdResponse implements ApplicationResponse {

    private final ExamenClinico examenClinico;

    public ExamenClinicoFindByIdResponse(ExamenClinico examenClinico) {
        this.examenClinico = examenClinico;
    }

    public ExamenClinico getExamenClinico() {
        return examenClinico;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
