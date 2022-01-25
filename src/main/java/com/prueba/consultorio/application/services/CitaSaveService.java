package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Cita;
import com.prueba.consultorio.application.domains.CitaTipo;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.errors.CitaTipoIdNotFound;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.errors.MedicoIdNotFound;
import com.prueba.consultorio.application.errors.PacienteIdNotFound;
import com.prueba.consultorio.application.models.cita.CitaSaveRequest;
import com.prueba.consultorio.application.models.cita.CitaSaveResponse;
import com.prueba.consultorio.application.ports.in.CitaSaveUseCase;
import com.prueba.consultorio.application.ports.out.CitaRepository;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;
import com.prueba.consultorio.application.ports.out.MedicoRepository;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

import java.util.Optional;

public class CitaSaveService implements CitaSaveUseCase {

    private final CitaRepository citaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepositiry pacienteRepositiry;
    private final CitaTipoRepository citaTipoRepository;

    public CitaSaveService(CitaRepository citaRepository, MedicoRepository medicoRepository, PacienteRepositiry pacienteRepositiry, CitaTipoRepository citaTipoRepository) {
        this.citaRepository = citaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepositiry = pacienteRepositiry;
        this.citaTipoRepository = citaTipoRepository;
    }

    @Override
    public CitaSaveResponse execute(CitaSaveRequest request) {
        Cita cita = validRequest(request);
        Optional<Cita> citaOptional = citaRepository.save(cita);
        if (!citaOptional.isPresent()){
            throw new RuntimeException("Error trying to save");
        }
        return new CitaSaveResponse(citaOptional.get());
    }

    private Cita validRequest(CitaSaveRequest citaSaveRequest){
        NonEmptyLocalDate fecha = Validate.nonEmptyLocalDate("fecha", citaSaveRequest.getFecha());
        NonEmptyLocalTime hora = Validate.nonEmptyLocalTime("hora", citaSaveRequest.getHora());
        Medico medico = validRequestMedico(citaSaveRequest);
        Paciente paciente = validRequestPaciente(citaSaveRequest);
        CitaTipo citaTipo = validRequestCitaTipo(citaSaveRequest);
        return new Cita(hora,fecha,paciente,medico,citaTipo);
    }

    private Medico validRequestMedico(CitaSaveRequest request){
        NonEmptyUUID id = Validate.nonEmptyUUID("medicoId", request.getMedicoId());
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if(!optionalMedico.isPresent()){
            throw new MedicoIdNotFound(id);
        }
        return optionalMedico.get();
    }

    private Paciente validRequestPaciente(CitaSaveRequest request){
        NonEmptyUUID id = Validate.nonEmptyUUID("pacienteId", request.getPacienteId());
        Optional<Paciente> optionalPaciente = pacienteRepositiry.findId(id);
        if(!optionalPaciente.isPresent()){
            throw new PacienteIdNotFound(id);
        }

        return optionalPaciente.get();
    }

    private CitaTipo validRequestCitaTipo(CitaSaveRequest request){
        NonEmptyUUID id = Validate.nonEmptyUUID("citaTipoId", request.getCitaTipoId());
        Optional<CitaTipo> optionalCitaTipo = citaTipoRepository.findById(id);
        if(!optionalCitaTipo.isPresent()){
            throw new CitaTipoIdNotFound(id);
        }
        return optionalCitaTipo.get();
    }

}

