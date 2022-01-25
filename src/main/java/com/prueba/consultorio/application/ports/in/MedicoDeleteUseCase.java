package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.medico.MedicoDeleteRequest;
import com.prueba.consultorio.application.models.medico.MedicoDeleteResponse;

public interface MedicoDeleteUseCase extends ApplicationUseCase<MedicoDeleteRequest, MedicoDeleteResponse> {
}
