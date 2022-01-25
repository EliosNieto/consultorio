package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.control.ControlFindByIdRequest;
import com.prueba.consultorio.application.models.control.ControlFindByIdResponse;

public interface ControlFindByIdUseCase extends ApplicationUseCase<ControlFindByIdRequest, ControlFindByIdResponse> {
}
