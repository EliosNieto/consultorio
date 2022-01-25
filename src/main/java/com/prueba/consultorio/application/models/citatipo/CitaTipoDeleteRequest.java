package com.prueba.consultorio.application.models.citatipo;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class CitaTipoDeleteRequest implements ApplicationRequest {

    private final String id;

    public CitaTipoDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
