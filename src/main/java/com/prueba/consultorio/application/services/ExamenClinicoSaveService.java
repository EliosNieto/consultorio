package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.ExamenClinico;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.errors.MedicoIdNotFound;
import com.prueba.consultorio.application.errors.PacienteIdNotFound;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoSaveRequest;
import com.prueba.consultorio.application.models.examenclinico.ExamenClinicoSaveResponse;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaSaveRequest;
import com.prueba.consultorio.application.ports.in.ExamenClinicoSaveUseCase;
import com.prueba.consultorio.application.ports.out.ExamenClinicoRepository;
import com.prueba.consultorio.application.ports.out.MedicoRepository;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

import java.util.Optional;

public class ExamenClinicoSaveService implements ExamenClinicoSaveUseCase {

    private final MedicoRepository medicoRepository;
    private final PacienteRepositiry pacienteRepositiry;
    private final ExamenClinicoRepository examenClinicoRepository;

    public ExamenClinicoSaveService(MedicoRepository medicoRepository, PacienteRepositiry pacienteRepositiry, ExamenClinicoRepository examenClinicoRepository) {
        this.medicoRepository = medicoRepository;
        this.pacienteRepositiry = pacienteRepositiry;
        this.examenClinicoRepository = examenClinicoRepository;
    }

    @Override
    public ExamenClinicoSaveResponse execute(ExamenClinicoSaveRequest request) {
        ExamenClinico examenClinico = validRequest(request);
        Optional<ExamenClinico> optionalExamenClinico = examenClinicoRepository.save(examenClinico);
        if(!optionalExamenClinico.isPresent()) {
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }
        return new ExamenClinicoSaveResponse(optionalExamenClinico.get());
    }

    private ExamenClinico validRequest(ExamenClinicoSaveRequest request){
        NonEmptyString estado = Validate.nonEmptyString("estado", request.getEstado());
        NonEmptyString resultado = Validate.nonEmptyString("resultado", request.getResultado());
        Medico medico = validRequestMedico(request);
        Paciente paciente = validRequestPaciente(request);
        return new ExamenClinico(medico, paciente, estado, resultado);
    }

    private Medico validRequestMedico(ExamenClinicoSaveRequest request){
        NonEmptyUUID medicoId = Validate.nonEmptyUUID("medicoId", request.getMedicoId());
        Optional<Medico> optionalMedico = medicoRepository.findById(medicoId);
        if (!optionalMedico.isPresent()){
            throw new MedicoIdNotFound(medicoId);
        }
        return optionalMedico.get();
    }

    private Paciente validRequestPaciente(ExamenClinicoSaveRequest request){
        NonEmptyUUID pacienteId = Validate.nonEmptyUUID("pacienteId", request.getPacienteId());
        Optional<Paciente> optionalPaciente = pacienteRepositiry.findId(pacienteId);
        if(!optionalPaciente.isPresent()){
            throw new PacienteIdNotFound(pacienteId);
        }
        return optionalPaciente.get();
    }
}
