package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.especialidad.EspecialidadListRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadListResponse;

public interface EspecialidadListUseCase extends ApplicationUseCase<EspecialidadListRequest, EspecialidadListResponse> {
}
