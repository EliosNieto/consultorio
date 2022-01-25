package com.prueba.consultorio.application.errors;

import com.prueba.consultorio.application.commons.errors.ApplicationError;
import com.prueba.consultorio.application.commons.errors.HttpStatusCode;

import java.util.Map;

public class InputDataError extends ApplicationError {

    private final String message;
    private final String parameter;
    private final String value;

    public InputDataError(String message, String parameter, String value) {
        this.message = message;
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String errorCode() {
        return "INPUT_DATA_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.BAD_REQUEST;
    }

    @Override
    public Map<String, Object> metadata() {
        if (parameter == null) {
            return super.metadata();
        }
        return Map.of(parameter, value);
    }
}
