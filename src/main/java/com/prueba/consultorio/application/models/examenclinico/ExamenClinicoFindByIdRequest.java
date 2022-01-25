package com.prueba.consultorio.application.models.examenclinico;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class ExamenClinicoFindByIdRequest implements ApplicationRequest {

    private final String id;

    public ExamenClinicoFindByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
