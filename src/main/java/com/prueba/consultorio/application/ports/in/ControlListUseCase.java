package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.control.ControlListRequest;
import com.prueba.consultorio.application.models.control.ControlListResponse;

public interface ControlListUseCase extends ApplicationUseCase<ControlListRequest, ControlListResponse> {
}
