package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.enfermera.EnfermeraListRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraListResponse;

public interface EnfermeraListUseCase extends ApplicationUseCase<EnfermeraListRequest, EnfermeraListResponse> {
}
