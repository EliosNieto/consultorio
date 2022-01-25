package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.paciente.PacienteSaveRequest;
import com.prueba.consultorio.application.models.paciente.PacienteSaveResponse;

public interface PacienteSaveUseCase extends ApplicationUseCase<PacienteSaveRequest, PacienteSaveResponse> {
}
