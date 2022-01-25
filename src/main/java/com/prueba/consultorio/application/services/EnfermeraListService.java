package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.enfermera.EnfermeraListRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraListResponse;
import com.prueba.consultorio.application.ports.in.EnfermeraListUseCase;
import com.prueba.consultorio.application.ports.out.EnfermeraRepository;

import java.util.ArrayList;

public class EnfermeraListService implements EnfermeraListUseCase {

    private final EnfermeraRepository enfermeraRepository;

    public EnfermeraListService(EnfermeraRepository enfermeraRepository) {
        this.enfermeraRepository = enfermeraRepository;
    }

    @Override
    public EnfermeraListResponse execute(EnfermeraListRequest request) {
        return new EnfermeraListResponse(enfermeraRepository.list());
    }


}
