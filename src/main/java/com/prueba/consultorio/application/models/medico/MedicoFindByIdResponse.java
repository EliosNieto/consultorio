package com.prueba.consultorio.application.models.medico;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Medico;

public class MedicoFindByIdResponse implements ApplicationResponse {

    private final Medico medico;

    public MedicoFindByIdResponse(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
