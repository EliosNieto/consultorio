package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.especialidad.EspecialidadSaveRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadSaveResponse;

public interface EspecialidadSaveUseCase extends ApplicationUseCase<EspecialidadSaveRequest, EspecialidadSaveResponse> {
}
