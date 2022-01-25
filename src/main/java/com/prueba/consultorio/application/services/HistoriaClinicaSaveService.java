package com.prueba.consultorio.application.services;


import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.HistoriaClinica;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.errors.MedicoIdNotFound;
import com.prueba.consultorio.application.errors.PacienteIdNotFound;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaSaveRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaSaveResponse;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaSaveUseCase;
import com.prueba.consultorio.application.ports.out.HistoriaClinicaRepository;
import com.prueba.consultorio.application.ports.out.MedicoRepository;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

import java.util.Optional;

public class HistoriaClinicaSaveService implements HistoriaClinicaSaveUseCase {

    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final PacienteRepositiry pacienteRepositiry;
    private final MedicoRepository medicoRepository;

    public HistoriaClinicaSaveService(HistoriaClinicaRepository historiaClinicaRepository, PacienteRepositiry pacienteRepositiry, MedicoRepository medicoRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
        this.pacienteRepositiry = pacienteRepositiry;
        this.medicoRepository = medicoRepository;
    }

    @Override
    public HistoriaClinicaSaveResponse execute(HistoriaClinicaSaveRequest request) {
        HistoriaClinica historiaClinica = validRequest(request);
        Optional<HistoriaClinica> optionalHistoriaClinica = historiaClinicaRepository.save(historiaClinica);
        if(!optionalHistoriaClinica.isPresent()){
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }
        return new HistoriaClinicaSaveResponse(optionalHistoriaClinica.get());
    }

    private HistoriaClinica validRequest(HistoriaClinicaSaveRequest request){
        NonEmptyString observacion = Validate.nonEmptyString("observacion", request.getObservacion());
        Medico medico = validRequestMedico(request);
        Paciente paciente = validRequestPaciente(request);
        return new HistoriaClinica(observacion,medico,paciente);
    }

    private Medico validRequestMedico(HistoriaClinicaSaveRequest request){
        NonEmptyUUID medicoId = Validate.nonEmptyUUID("medicoId", request.getMedicoId());
        Optional<Medico> optionalMedico = medicoRepository.findById(medicoId);
        if (!optionalMedico.isPresent()){
            throw new MedicoIdNotFound(medicoId);
        }
        return optionalMedico.get();
    }

    private Paciente validRequestPaciente(HistoriaClinicaSaveRequest request){
        NonEmptyUUID pacienteId = Validate.nonEmptyUUID("pacienteId", request.getPacienteId());
        Optional<Paciente> optionalPaciente = pacienteRepositiry.findId(pacienteId);
        if(!optionalPaciente.isPresent()){
            throw new PacienteIdNotFound(pacienteId);
        }
        return optionalPaciente.get();
    }
}
