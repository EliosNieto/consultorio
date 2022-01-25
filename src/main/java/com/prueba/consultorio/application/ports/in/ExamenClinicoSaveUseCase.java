package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoSaveRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoSaveResponse;

public interface ExamenClinicoSaveUseCase extends ApplicationUseCase<ExamenClinicoSaveRequest, ExamenClinicoSaveResponse> {
}
