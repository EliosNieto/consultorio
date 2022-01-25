package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaFindByIdRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaFindByIdResponse;

public interface HistoriaClinicaFindByIdUseCase extends ApplicationUseCase<HistoriaClinicaFindByIdRequest, HistoriaClinicaFindByIdResponse> {
}
