package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Enfermera;
import com.prueba.consultorio.application.errors.EnfermeraIdNotFound;
import com.prueba.consultorio.application.models.enfermera.EnfermeraDeleteRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraDeleteResponse;
import com.prueba.consultorio.application.ports.in.EnfermeraDeleteUseCase;
import com.prueba.consultorio.application.ports.out.EnfermeraRepository;

import java.util.Optional;

public class EnfermeraDeleteService implements EnfermeraDeleteUseCase {

    private final EnfermeraRepository enfermeraRepository;

    public EnfermeraDeleteService(EnfermeraRepository enfermeraRepository) {
        this.enfermeraRepository = enfermeraRepository;
    }

    @Override
    public EnfermeraDeleteResponse execute(EnfermeraDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Enfermera> optionalEnfermera = enfermeraRepository.findById(id);
        if(!optionalEnfermera.isPresent()){
            throw new EnfermeraIdNotFound(id);
        }
        return new EnfermeraDeleteResponse(id.getValue());
    }
}
