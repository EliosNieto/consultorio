package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoFindByIdRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoFindByIdResponse;

public interface ExamenClinicoFindByIdUseCase extends ApplicationUseCase<ExamenClinicoFindByIdRequest, ExamenClinicoFindByIdResponse> {
}
