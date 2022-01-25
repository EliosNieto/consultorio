package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.cita.CitaFindByIdRequest;
import com.prueba.consultorio.application.models.cita.CitaFindByIdResponse;

public interface CitaFindByIdUseCase extends ApplicationUseCase<CitaFindByIdRequest, CitaFindByIdResponse> {
}
