package com.prueba.consultorio.application.models.enfermera;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class EnfermeraFindByIdRequest implements ApplicationRequest {
    private String id;

    public EnfermeraFindByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
