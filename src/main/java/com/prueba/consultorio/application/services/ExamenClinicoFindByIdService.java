package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.ExamenClinico;
import com.prueba.consultorio.application.errors.ExamenClinicoIdNotFound;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoFindByIdRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoFindByIdResponse;
import com.prueba.consultorio.application.ports.in.ExamenClinicoFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.ExamenClinicoRepository;

import java.util.Optional;

public class ExamenClinicoFindByIdService implements ExamenClinicoFindByIdUseCase {

    private final ExamenClinicoRepository examenClinicoRepository;

    public ExamenClinicoFindByIdService(ExamenClinicoRepository examenClinicoRepository) {
        this.examenClinicoRepository = examenClinicoRepository;
    }

    @Override
    public ExamenClinicoFindByIdResponse execute(ExamenClinicoFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<ExamenClinico> optionalExamenClinico = examenClinicoRepository.findById(id);
        if(!optionalExamenClinico.isPresent()){
            throw new ExamenClinicoIdNotFound(id);
        }
        return new ExamenClinicoFindByIdResponse(optionalExamenClinico.get());
    }
}
