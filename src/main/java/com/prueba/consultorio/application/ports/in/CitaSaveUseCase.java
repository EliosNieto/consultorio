package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.cita.CitaSaveRequest;
import com.prueba.consultorio.application.models.cita.CitaSaveResponse;


public interface CitaSaveUseCase extends ApplicationUseCase<CitaSaveRequest, CitaSaveResponse> {
}
