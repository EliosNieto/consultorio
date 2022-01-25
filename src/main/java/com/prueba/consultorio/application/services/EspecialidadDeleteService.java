package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;
import com.prueba.consultorio.application.errors.EspecialidadIdNotFound;
import com.prueba.consultorio.application.models.especialidad.EspecialidadDeleteRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadDeleteResponse;
import com.prueba.consultorio.application.ports.in.EspecialidadDeleteUseCase;
import com.prueba.consultorio.application.ports.out.EspecialidadRepository;

import java.util.Optional;

public class EspecialidadDeleteService implements EspecialidadDeleteUseCase {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadDeleteService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public EspecialidadDeleteResponse execute(EspecialidadDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<MedicoEspecialidad> optionalMedicoEspecialidad = especialidadRepository.findById(id);
        if(!optionalMedicoEspecialidad.isPresent()){
            throw new EspecialidadIdNotFound(id);
        }
        return new EspecialidadDeleteResponse(id.getValue());
    }
}
