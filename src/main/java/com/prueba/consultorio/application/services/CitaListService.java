package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.cita.CitaListRequest;
import com.prueba.consultorio.application.models.cita.CitaListResponse;
import com.prueba.consultorio.application.ports.in.CitaListUseCase;
import com.prueba.consultorio.application.ports.out.CitaRepository;

public class CitaListService implements CitaListUseCase {

    private final CitaRepository citaRepository;

    public CitaListService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public CitaListResponse execute(CitaListRequest request) {
        return new CitaListResponse(citaRepository.list());
    }
}
