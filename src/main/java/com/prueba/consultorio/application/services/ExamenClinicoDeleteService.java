package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.ExamenClinico;
import com.prueba.consultorio.application.errors.ExamenClinicoIdNotFound;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoDeleteRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoDeleteResponse;
import com.prueba.consultorio.application.ports.in.ExamenClinicoDeleteUseCase;
import com.prueba.consultorio.application.ports.out.ExamenClinicoRepository;

import java.util.Optional;

public class ExamenClinicoDeleteService implements ExamenClinicoDeleteUseCase {

    private final ExamenClinicoRepository examenClinicoRepository;

    public ExamenClinicoDeleteService(ExamenClinicoRepository examenClinicoRepository) {
        this.examenClinicoRepository = examenClinicoRepository;
    }


    @Override
    public ExamenClinicoDeleteResponse execute(ExamenClinicoDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<ExamenClinico> optionalExamenClinico = examenClinicoRepository.findById(id);
        if(!optionalExamenClinico.isPresent()){
            throw new ExamenClinicoIdNotFound(id);
        }
        return new ExamenClinicoDeleteResponse(id.getValue());
    }
}
