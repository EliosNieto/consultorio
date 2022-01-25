package com.prueba.consultorio.application.models.enfermera;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class EnfermeraDeleteRequest implements ApplicationRequest {
    private String id;

    public EnfermeraDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
