package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.models.especialidad.EspecialidadSaveRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadSaveResponse;
import com.prueba.consultorio.application.ports.in.EspecialidadSaveUseCase;
import com.prueba.consultorio.application.ports.out.EspecialidadRepository;

import java.util.Optional;

public class EspecialidadSaveService implements EspecialidadSaveUseCase {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadSaveService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public EspecialidadSaveResponse execute(EspecialidadSaveRequest request) {
        MedicoEspecialidad medicoEspecialidad = validRequest(request);
        Optional<MedicoEspecialidad> especialidad = especialidadRepository.save(medicoEspecialidad);
        if(!especialidad.isPresent()){
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }
        return new EspecialidadSaveResponse(especialidad.get());
    }

    private MedicoEspecialidad validRequest(EspecialidadSaveRequest request){
        NonEmptyString nombre = Validate.nonEmptyString("nombre", request.getNombre());
        return new MedicoEspecialidad(nombre);
    }
}
