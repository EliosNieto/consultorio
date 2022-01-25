package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaDeleteRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaDeleteResponse;

public interface HistoriaClinicaDeleteUseCase extends ApplicationUseCase<HistoriaClinicaDeleteRequest, HistoriaClinicaDeleteResponse> {
}
