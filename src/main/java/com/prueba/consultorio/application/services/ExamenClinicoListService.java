package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoListRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoListResponse;
import com.prueba.consultorio.application.ports.in.ExamenClinicoListUseCase;
import com.prueba.consultorio.application.ports.out.ExamenClinicoRepository;

public class ExamenClinicoListService implements ExamenClinicoListUseCase {

    private final ExamenClinicoRepository examenClinicoRepository;

    public ExamenClinicoListService(ExamenClinicoRepository examenClinicoRepository) {
        this.examenClinicoRepository = examenClinicoRepository;
    }

    @Override
    public ExamenClinicoListResponse execute(ExamenClinicoListRequest request) {
        return new ExamenClinicoListResponse(examenClinicoRepository.list());
    }
}
