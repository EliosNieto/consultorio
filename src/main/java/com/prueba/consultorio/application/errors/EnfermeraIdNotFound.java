package com.prueba.consultorio.application.errors;


import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.errors.ApplicationError;
import com.prueba.consultorio.application.commons.errors.HttpStatusCode;

import java.util.Map;

public class EnfermeraIdNotFound extends ApplicationError {

    private final NonEmptyUUID id;

    public EnfermeraIdNotFound(NonEmptyUUID id) {
        this.id = id;
    }

    @Override
    public String errorCode() {
        return "ENFERMERA_NOT_FOUND_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return "Enfermera not found";
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "id", id.getValue()
        );
    }
}
