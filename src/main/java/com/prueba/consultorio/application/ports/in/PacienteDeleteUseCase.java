package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.paciente.PacienteDeleteRequest;
import com.prueba.consultorio.application.models.paciente.PacienteDeleteResponse;

public interface PacienteDeleteUseCase extends ApplicationUseCase<PacienteDeleteRequest, PacienteDeleteResponse> {

}
