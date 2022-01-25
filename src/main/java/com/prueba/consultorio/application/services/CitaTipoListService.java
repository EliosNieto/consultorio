package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.citatipo.CitaTipoListRequest;
import com.prueba.consultorio.application.models.citatipo.CitaTipoListResponse;
import com.prueba.consultorio.application.ports.in.CitaTipoListUseCase;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;

public class CitaTipoListService implements CitaTipoListUseCase {

    private final CitaTipoRepository citaTipoRepository;

    public CitaTipoListService(CitaTipoRepository citaTipoRepository) {
        this.citaTipoRepository = citaTipoRepository;
    }

    @Override
    public CitaTipoListResponse execute(CitaTipoListRequest request) {
        return new CitaTipoListResponse(citaTipoRepository.list());
    }
}
