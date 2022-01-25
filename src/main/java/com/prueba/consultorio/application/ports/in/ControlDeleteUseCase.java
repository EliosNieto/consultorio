package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.control.ControlDeleteRequest;
import com.prueba.consultorio.application.models.control.ControlDeleteResponse;

public interface ControlDeleteUseCase extends ApplicationUseCase<ControlDeleteRequest, ControlDeleteResponse> {
}
