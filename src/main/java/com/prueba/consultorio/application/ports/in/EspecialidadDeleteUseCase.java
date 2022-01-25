package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.especialidad.EspecialidadDeleteRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadDeleteResponse;

public interface EspecialidadDeleteUseCase extends ApplicationUseCase<EspecialidadDeleteRequest, EspecialidadDeleteResponse> {
}
