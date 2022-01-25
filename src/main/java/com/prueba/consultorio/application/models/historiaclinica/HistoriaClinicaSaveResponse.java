package com.prueba.consultorio.application.models.historiaclinica;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.HistoriaClinica;

public class HistoriaClinicaSaveResponse implements ApplicationResponse {

    private final HistoriaClinica historiaClinica;

    public HistoriaClinicaSaveResponse(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
