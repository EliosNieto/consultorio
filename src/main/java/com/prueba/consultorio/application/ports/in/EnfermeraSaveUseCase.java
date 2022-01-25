package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.enfermera.EnfermeraSaveRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraSaveResponse;

public interface EnfermeraSaveUseCase extends ApplicationUseCase<EnfermeraSaveRequest, EnfermeraSaveResponse> {
}
