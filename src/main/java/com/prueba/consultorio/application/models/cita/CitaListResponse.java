package com.prueba.consultorio.application.models.cita;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Cita;

import java.util.List;

public class CitaListResponse implements ApplicationResponse {

    private final List<Cita> citas;

    public CitaListResponse(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
