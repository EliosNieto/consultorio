package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.CitaTipo;
import com.prueba.consultorio.application.errors.CitaTipoIdNotFound;
import com.prueba.consultorio.application.models.citatipo.CitaTipoFindByIdRequest;
import com.prueba.consultorio.application.models.citatipo.CitaTipoFindByIdResponse;
import com.prueba.consultorio.application.ports.in.CitaTipoFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;

import java.util.Optional;

public class CitaTipoFindByIdService implements CitaTipoFindByIdUseCase {

    private final CitaTipoRepository citaTipoRepository;

    public CitaTipoFindByIdService(CitaTipoRepository citaTipoRepository) {
        this.citaTipoRepository = citaTipoRepository;
    }

    @Override
    public CitaTipoFindByIdResponse execute(CitaTipoFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<CitaTipo> optionalCitaTipo = citaTipoRepository.findById(id);
        if(!optionalCitaTipo.isPresent()){
            throw new CitaTipoIdNotFound(id);
        }
        return new CitaTipoFindByIdResponse(optionalCitaTipo.get());
    }
}
