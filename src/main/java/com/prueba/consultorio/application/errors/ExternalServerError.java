package com.prueba.consultorio.application.errors;


import com.prueba.consultorio.application.commons.errors.ApplicationError;
import com.prueba.consultorio.application.commons.errors.HttpStatusCode;

import java.util.Map;

public class ExternalServerError extends ApplicationError {

    private final String message;
    private final Throwable throwable;

    public ExternalServerError(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    @Override
    public String errorCode() {
        return "EXTERNAL_SYSTEM_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of("throwable",throwable);
    }
}
