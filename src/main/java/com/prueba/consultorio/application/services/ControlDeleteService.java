package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import com.prueba.consultorio.application.domains.Control;
import com.prueba.consultorio.application.errors.ControlIdNotFound;
import com.prueba.consultorio.application.models.control.ControlDeleteRequest;
import com.prueba.consultorio.application.models.control.ControlDeleteResponse;
import com.prueba.consultorio.application.models.control.ControlSaveResponse;
import com.prueba.consultorio.application.ports.in.ControlDeleteUseCase;
import com.prueba.consultorio.application.ports.out.ControlRepository;

import java.util.Optional;

public class ControlDeleteService implements ControlDeleteUseCase {

    private final ControlRepository controlRepository;

    public ControlDeleteService(ControlRepository controlRepository) {
        this.controlRepository = controlRepository;
    }

    @Override
    public ControlDeleteResponse execute(ControlDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Control> optionalControl = controlRepository.findById(id);
        if(!optionalControl.isPresent()){
            throw new ControlIdNotFound(id);
        }
        return new ControlDeleteResponse(id.getValue());
    }
}
