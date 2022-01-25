package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Control;
import com.prueba.consultorio.application.errors.ControlIdNotFound;
import com.prueba.consultorio.application.models.control.ControlFindByIdRequest;
import com.prueba.consultorio.application.models.control.ControlFindByIdResponse;
import com.prueba.consultorio.application.ports.in.ControlFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.ControlRepository;

import java.util.Optional;

public class ControlFindByIdService implements ControlFindByIdUseCase {

    private final ControlRepository controlRepository;

    public ControlFindByIdService(ControlRepository controlRepository) {
        this.controlRepository = controlRepository;
    }

    @Override
    public ControlFindByIdResponse execute(ControlFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Control> optionalControl = controlRepository.findById(id);
        if(!optionalControl.isPresent()){
            throw new ControlIdNotFound(id);
        }
        return new ControlFindByIdResponse(optionalControl.get());
    }
}
