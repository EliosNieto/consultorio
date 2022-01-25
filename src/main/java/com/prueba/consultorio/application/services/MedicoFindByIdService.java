package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.errors.MedicoIdNotFound;
import com.prueba.consultorio.application.models.medico.MedicoFindByIdRequest;
import com.prueba.consultorio.application.models.medico.MedicoFindByIdResponse;
import com.prueba.consultorio.application.ports.in.MedicoFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.MedicoRepository;

import java.util.Optional;

public class MedicoFindByIdService implements MedicoFindByIdUseCase {

    private final MedicoRepository medicoRepository;

    public MedicoFindByIdService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public MedicoFindByIdResponse execute(MedicoFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if (!optionalMedico.isPresent()){
            throw new MedicoIdNotFound(id);
        }
        return new MedicoFindByIdResponse(optionalMedico.get());
    }
}
