package com.prueba.consultorio.application.ports.in;

import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaSaveRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaSaveResponse;

public interface HistoriaClinicaSaveUseCase extends ApplicationUseCase<HistoriaClinicaSaveRequest, HistoriaClinicaSaveResponse> {
}
