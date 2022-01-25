package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.errors.PacienteIdNotFound;
import com.prueba.consultorio.application.models.paciente.PacienteDeleteRequest;
import com.prueba.consultorio.application.models.paciente.PacienteDeleteResponse;
import com.prueba.consultorio.application.ports.in.PacienteDeleteUseCase;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

import java.util.Optional;

public class PacienteDeleteService implements PacienteDeleteUseCase {

    private final PacienteRepositiry pacienteRepositiry;

    public PacienteDeleteService(PacienteRepositiry pacienteRepositiry) {
        this.pacienteRepositiry = pacienteRepositiry;
    }

    @Override
    public PacienteDeleteResponse execute(PacienteDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Paciente> optionalPaciente = pacienteRepositiry.findId(id);
        if(!optionalPaciente.isPresent()){
            throw new PacienteIdNotFound(id);
        }
        return new PacienteDeleteResponse(id.getValue());
    }
}
