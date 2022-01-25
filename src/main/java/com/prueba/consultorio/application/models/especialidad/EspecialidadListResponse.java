package com.prueba.consultorio.application.models.especialidad;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;

import java.util.List;

public class EspecialidadListResponse implements ApplicationResponse {

    private final List<MedicoEspecialidad> especialidades;

    public EspecialidadListResponse(List<MedicoEspecialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public List<MedicoEspecialidad> getEspecialidades() {
        return especialidades;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
