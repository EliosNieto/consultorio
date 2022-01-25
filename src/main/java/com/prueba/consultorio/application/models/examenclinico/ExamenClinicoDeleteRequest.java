package com.prueba.consultorio.application.models.examenclinico;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class ExamenClinicoDeleteRequest implements ApplicationRequest {

    private final String id;

    public ExamenClinicoDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
