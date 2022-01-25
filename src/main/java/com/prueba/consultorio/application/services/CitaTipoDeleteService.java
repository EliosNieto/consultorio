package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.CitaTipo;
import com.prueba.consultorio.application.errors.CitaTipoIdNotFound;
import com.prueba.consultorio.application.models.citatipo.CitaTipoDeleteRequest;
import com.prueba.consultorio.application.models.citatipo.CitaTipoDeleteResponse;
import com.prueba.consultorio.application.ports.in.CitaTipoDeleteUseCase;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;

import java.util.Optional;

public class CitaTipoDeleteService implements CitaTipoDeleteUseCase {

    private final CitaTipoRepository citaTipoRepository;

    public CitaTipoDeleteService(CitaTipoRepository citaTipoRepository) {
        this.citaTipoRepository = citaTipoRepository;
    }

    @Override
    public CitaTipoDeleteResponse execute(CitaTipoDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<CitaTipo> optionalCitaTipo = citaTipoRepository.findById(id);
        if(!optionalCitaTipo.isPresent()){
            throw new CitaTipoIdNotFound(id);
        }
        return new CitaTipoDeleteResponse(id.getValue());
    }
}
