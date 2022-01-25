package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;
import com.prueba.consultorio.application.errors.EspecialidadIdNotFound;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.models.medico.MedicoSaveRequest;
import com.prueba.consultorio.application.models.medico.MedicoSaveResponse;
import com.prueba.consultorio.application.ports.in.MedicoSaveUseCase;
import com.prueba.consultorio.application.ports.out.EspecialidadRepository;
import com.prueba.consultorio.application.ports.out.MedicoRepository;

import java.util.Optional;

public class MedicoSaveService implements MedicoSaveUseCase {

    private final MedicoRepository medicoRepository;
    private final EspecialidadRepository especialidadRepository;

    public MedicoSaveService(MedicoRepository medicoRepository, EspecialidadRepository especialidadRepository) {
        this.medicoRepository = medicoRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public MedicoSaveResponse execute(MedicoSaveRequest request) {
        Medico medico = validRequest(request);
        Optional<Medico> optionalMedico = medicoRepository.save(medico);
        if(!optionalMedico.isPresent()){
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }
        return new MedicoSaveResponse(medico);
    }

    private Medico validRequest(MedicoSaveRequest request){
        NonEmptyString tipoDocumento = Validate.nonEmptyString("tipoDocumento", request.getTipoDocumento());
        NonEmptyNumber numeroDocumento = Validate.nonEmptyNumber("numeroDocumento", request.getNumeroDocumento());
        NonEmptyString nombres = Validate.nonEmptyString("nombres", request.getNombres());
        NonEmptyString tarjetaProfesional = Validate.nonEmptyString("tarjetaProfesional", request.getTarjetaProfesional());
        MedicoEspecialidad medicoEspecialidad = validEspecialidad(request.getMedicoEspecialidad());
        return new Medico(tipoDocumento,numeroDocumento,nombres,tarjetaProfesional,medicoEspecialidad);
    }

    private MedicoEspecialidad validEspecialidad(MedicoSaveRequest.MedicoEspecialidad request){
        NonEmptyUUID medicoEspecialidad = Validate.nonEmptyUUID("medicoEspecialidad", request.getId());
        Optional<MedicoEspecialidad> optionalMedicoEspecialidad = especialidadRepository.findById(medicoEspecialidad);
        if(!optionalMedicoEspecialidad.isPresent()){
            throw new EspecialidadIdNotFound(medicoEspecialidad);
        }
        return optionalMedicoEspecialidad.get();
    }
}
