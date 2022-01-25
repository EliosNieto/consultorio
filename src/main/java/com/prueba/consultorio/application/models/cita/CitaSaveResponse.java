package com.prueba.consultorio.application.models.cita;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Cita;

public class CitaSaveResponse implements ApplicationResponse {

    private final Cita cita;

    public CitaSaveResponse(Cita cita) {
        this.cita = cita;
    }

    public Cita getCita() {
        return cita;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
