package com.prueba.consultorio.application.models.enfermera;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Enfermera;

public class EnfermeraFindByIdResponse implements ApplicationResponse {

    private final Enfermera enfermera;

    public EnfermeraFindByIdResponse(Enfermera enfermera) {
        this.enfermera = enfermera;
    }

    public Enfermera getEnfermera() {
        return enfermera;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
