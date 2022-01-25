package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.paciente.PacienteListRequest;
import com.prueba.consultorio.application.models.paciente.PacienteListResponse;

public interface PacienteListUseCase extends ApplicationUseCase<PacienteListRequest, PacienteListResponse> {
}
