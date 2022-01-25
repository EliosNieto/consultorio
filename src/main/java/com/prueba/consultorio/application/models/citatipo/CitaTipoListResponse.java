package com.prueba.consultorio.application.models.citatipo;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.CitaTipo;

import java.util.List;

public class CitaTipoListResponse implements ApplicationResponse {

    private final List<CitaTipo> tipos;

    public CitaTipoListResponse(List<CitaTipo> tipos) {
        this.tipos = tipos;
    }

    public List<CitaTipo> getTipos() {
        return tipos;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}
