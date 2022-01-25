package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaListRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaListResponse;

public interface HistoriaClinicaListUseCase extends ApplicationUseCase<HistoriaClinicaListRequest, HistoriaClinicaListResponse> {
}
