package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.medico.MedicoSaveRequest;
import com.prueba.consultorio.application.models.medico.MedicoSaveResponse;

public interface MedicoSaveUseCase extends ApplicationUseCase<MedicoSaveRequest, MedicoSaveResponse> {
}
