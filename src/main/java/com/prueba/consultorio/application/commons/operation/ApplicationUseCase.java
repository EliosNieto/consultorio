package com.prueba.consultorio.application.commons.operation;

public interface ApplicationUseCase<IN extends ApplicationRequest, OUT extends ApplicationResponse> {
    OUT execute(IN request);
}
