package com.prueba.consultorio.application.models.paciente;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Paciente;

public class PacienteFindByIdResponse implements ApplicationResponse {

    private final Paciente paciente;

    public PacienteFindByIdResponse(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
