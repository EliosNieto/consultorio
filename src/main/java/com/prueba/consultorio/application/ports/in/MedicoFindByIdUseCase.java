package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.medico.MedicoFindByIdRequest;
import com.prueba.consultorio.application.models.medico.MedicoFindByIdResponse;

public interface MedicoFindByIdUseCase extends ApplicationUseCase<MedicoFindByIdRequest, MedicoFindByIdResponse> {
}
