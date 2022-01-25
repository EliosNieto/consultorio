package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.especialidad.EspecialidadFindByIdRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadFindByIdResponse;

public interface EspecialidadFindByIdUseCase extends ApplicationUseCase<EspecialidadFindByIdRequest, EspecialidadFindByIdResponse> {
}
