package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.medico.MedicoListRequest;
import com.prueba.consultorio.application.models.medico.MedicoListResponse;
import com.prueba.consultorio.application.ports.in.MedicoListUseCase;
import com.prueba.consultorio.application.ports.out.MedicoRepository;

public class MedicoListService implements MedicoListUseCase {

    private final MedicoRepository medicoRepository;

    public MedicoListService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public MedicoListResponse execute(MedicoListRequest request) {
        return new MedicoListResponse(medicoRepository.list());
    }
}
