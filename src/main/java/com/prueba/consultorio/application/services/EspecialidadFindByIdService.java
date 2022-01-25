package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;
import com.prueba.consultorio.application.errors.EspecialidadIdNotFound;
import com.prueba.consultorio.application.models.especialidad.EspecialidadFindByIdRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadFindByIdResponse;
import com.prueba.consultorio.application.ports.in.EspecialidadFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.EspecialidadRepository;

import java.util.Optional;

public class EspecialidadFindByIdService implements EspecialidadFindByIdUseCase {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadFindByIdService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public EspecialidadFindByIdResponse execute(EspecialidadFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<MedicoEspecialidad> optionalMedicoEspecialidad = especialidadRepository.findById(id);
        if (!optionalMedicoEspecialidad.isPresent()){
            throw new EspecialidadIdNotFound(id);
        }
        return new EspecialidadFindByIdResponse(optionalMedicoEspecialidad.get());
    }
}
