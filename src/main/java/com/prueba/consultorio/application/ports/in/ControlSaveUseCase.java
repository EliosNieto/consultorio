package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.control.ControlSaveRequest;
import com.prueba.consultorio.application.models.control.ControlSaveResponse;

public interface ControlSaveUseCase extends ApplicationUseCase<ControlSaveRequest, ControlSaveResponse> {
}
