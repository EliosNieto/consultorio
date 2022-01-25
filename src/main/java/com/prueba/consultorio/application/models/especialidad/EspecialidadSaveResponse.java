package com.prueba.consultorio.application.models.especialidad;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;

public class EspecialidadSaveResponse implements ApplicationResponse {

    private final MedicoEspecialidad especialidad;

    public EspecialidadSaveResponse(MedicoEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

    public MedicoEspecialidad getEspecialidad() {
        return especialidad;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
