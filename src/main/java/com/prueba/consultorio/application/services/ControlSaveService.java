package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.*;
import com.prueba.consultorio.application.domains.Control;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.errors.MedicoIdNotFound;
import com.prueba.consultorio.application.errors.PacienteIdNotFound;
import com.prueba.consultorio.application.models.control.ControlSaveRequest;
import com.prueba.consultorio.application.models.control.ControlSaveResponse;
import com.prueba.consultorio.application.ports.in.ControlSaveUseCase;
import com.prueba.consultorio.application.ports.out.ControlRepository;
import com.prueba.consultorio.application.ports.out.MedicoRepository;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

import java.util.Optional;

public class ControlSaveService implements ControlSaveUseCase {

    private final ControlRepository controlRepository;
    private final PacienteRepositiry pacienteRepositiry;
    private final MedicoRepository medicoRepository;

    public ControlSaveService(ControlRepository controlRepository, PacienteRepositiry pacienteRepositiry, MedicoRepository medicoRepository) {
        this.controlRepository = controlRepository;
        this.pacienteRepositiry = pacienteRepositiry;
        this.medicoRepository = medicoRepository;
    }

    @Override
    public ControlSaveResponse execute(ControlSaveRequest request) {
        Control control = validRequest(request);
        Optional<Control> optionalControl = controlRepository.save(control);
        if(!optionalControl.isPresent()){
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }

        return new ControlSaveResponse(optionalControl.get());
    }

    private Control validRequest(ControlSaveRequest request){
        NonEmptyLocalDate fecha = Validate.nonEmptyLocalDate("fecha", request.getFecha());
        NonEmptyLocalTime hora = Validate.nonEmptyLocalTime("hora", request.getHora());
        NonEmptyString observacion = Validate.nonEmptyString("observacion", request.getObservacion());
        Medico medico = validRequestMedico(request);
        Paciente paciente = validRequestPaciente(request);
        return new Control(paciente,medico, fecha,hora, observacion);
    }

    private Medico validRequestMedico(ControlSaveRequest request){
        NonEmptyUUID medicoId = Validate.nonEmptyUUID("medicoId", request.getMedicoId());
        Optional<Medico> optionalMedico = medicoRepository.findById(medicoId);
        if (!optionalMedico.isPresent()){
            throw new MedicoIdNotFound(medicoId);
        }
        return optionalMedico.get();
    }

    private Paciente validRequestPaciente(ControlSaveRequest request){
        NonEmptyUUID pacienteId = Validate.nonEmptyUUID("pacienteId", request.getPacienteId());
        Optional<Paciente> optionalPaciente = pacienteRepositiry.findId(pacienteId);
        if (!optionalPaciente.isPresent()){
            throw new PacienteIdNotFound(pacienteId);
        }
        return optionalPaciente.get();
    }
}
