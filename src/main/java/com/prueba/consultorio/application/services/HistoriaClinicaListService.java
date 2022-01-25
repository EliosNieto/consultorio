package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaListRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaListResponse;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaListUseCase;
import com.prueba.consultorio.application.ports.out.HistoriaClinicaRepository;

public class HistoriaClinicaListService implements HistoriaClinicaListUseCase {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinicaListService(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public HistoriaClinicaListResponse execute(HistoriaClinicaListRequest request) {
        return new HistoriaClinicaListResponse(historiaClinicaRepository.list());
    }
}
