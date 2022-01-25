package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.enfermera.EnfermeraDeleteRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraDeleteResponse;

public interface EnfermeraDeleteUseCase extends ApplicationUseCase<EnfermeraDeleteRequest, EnfermeraDeleteResponse> {
}
