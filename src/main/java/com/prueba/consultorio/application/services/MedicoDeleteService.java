package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.errors.MedicoIdNotFound;
import com.prueba.consultorio.application.models.medico.MedicoDeleteRequest;
import com.prueba.consultorio.application.models.medico.MedicoDeleteResponse;
import com.prueba.consultorio.application.ports.in.MedicoDeleteUseCase;
import com.prueba.consultorio.application.ports.out.MedicoRepository;

import java.util.Optional;

public class MedicoDeleteService implements MedicoDeleteUseCase{

    private final MedicoRepository medicoRepository;

    public MedicoDeleteService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public MedicoDeleteResponse execute(MedicoDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if(!optionalMedico.isPresent()){
            throw new MedicoIdNotFound(id);
        }
        return new MedicoDeleteResponse(id.getValue());
    }
}
