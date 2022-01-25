package com.prueba.consultorio.application.commons.operation;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;

public interface ApplicationResponse {
    HttpStatusCode statusCode();
}
