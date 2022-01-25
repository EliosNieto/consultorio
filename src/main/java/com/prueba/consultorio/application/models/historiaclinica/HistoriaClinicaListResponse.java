package com.prueba.consultorio.application.models.historiaclinica;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.HistoriaClinica;

import java.util.List;

public class HistoriaClinicaListResponse implements ApplicationResponse {

    private final List<HistoriaClinica> historiaClinicas;

    public HistoriaClinicaListResponse(List<HistoriaClinica> historiaClinicas) {
        this.historiaClinicas = historiaClinicas;
    }

    public List<HistoriaClinica> getHistoriaClinicas() {
        return historiaClinicas;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
