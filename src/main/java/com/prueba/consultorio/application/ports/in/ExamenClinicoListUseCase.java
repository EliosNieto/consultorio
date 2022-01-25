package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoListRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoListResponse;

public interface ExamenClinicoListUseCase extends ApplicationUseCase<ExamenClinicoListRequest, ExamenClinicoListResponse> {
}
