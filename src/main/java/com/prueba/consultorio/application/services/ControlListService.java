package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.control.ControlListRequest;
import com.prueba.consultorio.application.models.control.ControlListResponse;
import com.prueba.consultorio.application.ports.in.ControlListUseCase;
import com.prueba.consultorio.application.ports.out.ControlRepository;

public class ControlListService implements ControlListUseCase {

    private final ControlRepository controlRepository;

    public ControlListService(ControlRepository controlRepository) {
        this.controlRepository = controlRepository;
    }

    @Override
    public ControlListResponse execute(ControlListRequest request) {
        return new ControlListResponse(controlRepository.list());
    }
}
