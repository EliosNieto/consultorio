package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.models.paciente.PacienteSaveRequest;
import com.prueba.consultorio.application.models.paciente.PacienteSaveResponse;
import com.prueba.consultorio.application.ports.in.PacienteSaveUseCase;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

import java.util.Optional;

public class PacienteSaveService implements PacienteSaveUseCase {

    private final PacienteRepositiry pacienteRepositiry;

    public PacienteSaveService(PacienteRepositiry pacienteRepositiry) {
        this.pacienteRepositiry = pacienteRepositiry;
    }

    @Override
    public PacienteSaveResponse execute(PacienteSaveRequest request) {
        Paciente paciente = validRequest(request);
        Optional<Paciente> optionalPaciente = pacienteRepositiry.save(paciente);
        if (!optionalPaciente.isPresent()){
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }
        return new PacienteSaveResponse(optionalPaciente.get());
    }

    private Paciente validRequest(PacienteSaveRequest request){
        NonEmptyString tipoDocumento = Validate.nonEmptyString("tipoDocumento", request.getTipoDocumento());
        NonEmptyNumber numeroDocumento = Validate.nonEmptyNumber("numeroDocumento", request.getNumeroDocumento());
        NonEmptyString nombres = Validate.nonEmptyString("nombres", request.getNombres());

        return new Paciente(tipoDocumento,numeroDocumento, nombres);
    }
}
