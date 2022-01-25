package com.prueba.consultorio.application.models.paciente;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Paciente;

import java.util.List;

public class PacienteListResponse implements ApplicationResponse {

    private final List<Paciente> pacientes;

    public PacienteListResponse(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
