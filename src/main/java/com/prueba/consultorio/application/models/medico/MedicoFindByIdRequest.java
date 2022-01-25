package com.prueba.consultorio.application.models.medico;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class MedicoFindByIdRequest implements ApplicationRequest {

    private final String id;

    public MedicoFindByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
