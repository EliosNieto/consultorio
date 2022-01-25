package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.errors.PacienteIdNotFound;
import com.prueba.consultorio.application.models.paciente.PacienteFindByIdRequest;
import com.prueba.consultorio.application.models.paciente.PacienteFindByIdResponse;
import com.prueba.consultorio.application.ports.in.PacienteFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

import java.util.Optional;

public class PacienteFindByIdService implements PacienteFindByIdUseCase {

    private final PacienteRepositiry pacienteRepositiry;

    public PacienteFindByIdService(PacienteRepositiry pacienteRepositiry) {
        this.pacienteRepositiry = pacienteRepositiry;
    }

    @Override
    public PacienteFindByIdResponse execute(PacienteFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Paciente> optionalPaciente = pacienteRepositiry.findId(id);
        if (!optionalPaciente.isPresent()){
            throw new PacienteIdNotFound(id);
        }
        return new PacienteFindByIdResponse(optionalPaciente.get());
    }
}
