package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Enfermera;
import com.prueba.consultorio.application.errors.EnfermeraIdNotFound;
import com.prueba.consultorio.application.models.enfermera.EnfermeraFindByIdRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraFindByIdResponse;
import com.prueba.consultorio.application.ports.in.EnfermeraFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.EnfermeraRepository;

import java.util.Optional;

public class EnfermeraFindByIdService implements EnfermeraFindByIdUseCase {

    private final EnfermeraRepository enfermeraRepository;

    public EnfermeraFindByIdService(EnfermeraRepository enfermeraRepository) {
        this.enfermeraRepository = enfermeraRepository;
    }

    @Override
    public EnfermeraFindByIdResponse execute(EnfermeraFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Enfermera> optionalEnfermera = enfermeraRepository.findById(id);
        if(!optionalEnfermera.isPresent()){
            throw new EnfermeraIdNotFound(id);
        }
        return new EnfermeraFindByIdResponse(optionalEnfermera.get());
    }
}
