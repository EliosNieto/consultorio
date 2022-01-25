package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.cita.CitaListRequest;
import com.prueba.consultorio.application.models.cita.CitaListResponse;

public interface CitaListUseCase extends ApplicationUseCase<CitaListRequest, CitaListResponse> {
}
