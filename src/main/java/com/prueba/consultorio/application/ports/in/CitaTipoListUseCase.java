package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.citatipo.CitaTipoListRequest;
import com.prueba.consultorio.application.models.citatipo.CitaTipoListResponse;

public interface CitaTipoListUseCase extends ApplicationUseCase<CitaTipoListRequest, CitaTipoListResponse> {
}
