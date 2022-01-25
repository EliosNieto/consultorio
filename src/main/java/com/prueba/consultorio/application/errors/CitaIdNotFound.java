package com.prueba.consultorio.application.errors;


import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.errors.ApplicationError;
import com.prueba.consultorio.application.commons.errors.HttpStatusCode;

import java.util.Map;

public class CitaIdNotFound extends ApplicationError {

    private final NonEmptyUUID id;

    public CitaIdNotFound(NonEmptyUUID id) {
        this.id = id;
    }

    @Override
    public String errorCode() {
        return "CITA_NOT_FOUND_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return "Cita not found";
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "id", id.getValue()
        );
    }
}
