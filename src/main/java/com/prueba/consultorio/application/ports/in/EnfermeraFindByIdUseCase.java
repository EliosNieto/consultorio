package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.enfermera.EnfermeraFindByIdRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraFindByIdResponse;

public interface EnfermeraFindByIdUseCase extends ApplicationUseCase<EnfermeraFindByIdRequest, EnfermeraFindByIdResponse> {
}
