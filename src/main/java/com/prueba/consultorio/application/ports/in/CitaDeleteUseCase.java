package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.cita.CitaDeleteRequest;
import com.prueba.consultorio.application.models.cita.CitaDeleteResponse;

public interface CitaDeleteUseCase extends ApplicationUseCase<CitaDeleteRequest, CitaDeleteResponse> {
}