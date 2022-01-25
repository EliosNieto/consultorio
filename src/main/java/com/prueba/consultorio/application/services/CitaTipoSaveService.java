package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.CitaTipo;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.models.citatipo.CitaTipoSaveRequest;
import com.prueba.consultorio.application.models.citatipo.CitaTipoSaveResponse;
import com.prueba.consultorio.application.ports.in.CitaTipoSaveUseCase;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;

import java.util.Optional;

public class CitaTipoSaveService implements CitaTipoSaveUseCase {

    private final CitaTipoRepository citaTipoRepository;

    public CitaTipoSaveService(CitaTipoRepository citaTipoRepository) {
        this.citaTipoRepository = citaTipoRepository;
    }

    @Override
    public CitaTipoSaveResponse execute(CitaTipoSaveRequest request) {
        CitaTipo citaTipo = validRequest(request);
        Optional<CitaTipo> optionalCitaTipo = citaTipoRepository.save(citaTipo);
        if(!optionalCitaTipo.isPresent()){
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }
        return new CitaTipoSaveResponse(optionalCitaTipo.get());
    }

    private CitaTipo validRequest(CitaTipoSaveRequest request){
        NonEmptyString nombre = Validate.nonEmptyString("nombre", request.getNombre());
        return new CitaTipo(nombre);
    }

}
