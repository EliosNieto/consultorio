package com.prueba.consultorio.application.models.control;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class ControlDeleteRequest implements ApplicationRequest {
    private final String id;

    public ControlDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
