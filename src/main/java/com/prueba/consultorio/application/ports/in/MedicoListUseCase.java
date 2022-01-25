package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.medico.MedicoListRequest;
import com.prueba.consultorio.application.models.medico.MedicoListResponse;

public interface MedicoListUseCase extends ApplicationUseCase<MedicoListRequest, MedicoListResponse> {
}
