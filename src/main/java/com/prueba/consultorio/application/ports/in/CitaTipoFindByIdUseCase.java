package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.citatipo.CitaTipoFindByIdRequest;
import com.prueba.consultorio.application.models.citatipo.CitaTipoFindByIdResponse;

public interface CitaTipoFindByIdUseCase extends ApplicationUseCase<CitaTipoFindByIdRequest, CitaTipoFindByIdResponse> {
}
