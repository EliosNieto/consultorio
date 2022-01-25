package com.prueba.consultorio.application.models.citatipo;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.CitaTipo;

public class CitaTipoSaveResponse implements ApplicationResponse {

    private final CitaTipo tipo;

    public CitaTipoSaveResponse(CitaTipo tipo) {
        this.tipo = tipo;
    }

    public CitaTipo getTipo() {
        return tipo;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
