package com.prueba.consultorio.application.models.examenclinico;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.ExamenClinico;

import java.util.List;

public class ExamenClinicoListResponse implements ApplicationResponse {

    private final List<ExamenClinico> examenClinicos;

    public ExamenClinicoListResponse(List<ExamenClinico> examenClinicos) {
        this.examenClinicos = examenClinicos;
    }

    public List<ExamenClinico> getExamenClinicos() {
        return examenClinicos;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
