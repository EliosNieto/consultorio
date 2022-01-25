package com.prueba.consultorio.application.models.historiaclinica;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class HistoriaClinicaDeleteRequest implements ApplicationRequest {
    private final String id;

    public HistoriaClinicaDeleteRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
