package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.paciente.PacienteFindByIdRequest;
import com.prueba.consultorio.application.models.paciente.PacienteFindByIdResponse;

public interface PacienteFindByIdUseCase extends ApplicationUseCase<PacienteFindByIdRequest, PacienteFindByIdResponse> {
}
