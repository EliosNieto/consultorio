package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoDeleteRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoDeleteResponse;

public interface ExamenClinicoDeleteUseCase extends ApplicationUseCase<ExamenClinicoDeleteRequest, ExamenClinicoDeleteResponse> {
}
