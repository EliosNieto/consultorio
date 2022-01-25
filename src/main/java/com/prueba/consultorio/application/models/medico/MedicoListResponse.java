package com.prueba.consultorio.application.models.medico;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Medico;

import java.util.List;

public class MedicoListResponse implements ApplicationResponse {

    private final List<Medico> medicos;

    public MedicoListResponse(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
