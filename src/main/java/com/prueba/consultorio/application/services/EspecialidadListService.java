package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.especialidad.EspecialidadListRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadListResponse;
import com.prueba.consultorio.application.ports.in.EspecialidadListUseCase;
import com.prueba.consultorio.application.ports.out.EspecialidadRepository;

public class EspecialidadListService implements EspecialidadListUseCase {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadListService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public EspecialidadListResponse execute(EspecialidadListRequest request) {
        return new EspecialidadListResponse(especialidadRepository.list());
    }
}
