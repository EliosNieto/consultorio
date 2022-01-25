package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Cita;
import com.prueba.consultorio.application.errors.CitaIdNotFound;
import com.prueba.consultorio.application.models.cita.CitaDeleteRequest;
import com.prueba.consultorio.application.models.cita.CitaDeleteResponse;
import com.prueba.consultorio.application.ports.in.CitaDeleteUseCase;
import com.prueba.consultorio.application.ports.out.CitaRepository;

import java.util.Optional;

public class CitaDeleteService implements CitaDeleteUseCase {

    private final CitaRepository citaRepository;

    public CitaDeleteService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public CitaDeleteResponse execute(CitaDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Cita> optionalCita = citaRepository.findById(id);
        if(!optionalCita.isPresent()){
            throw new CitaIdNotFound(id);
        }
        return new CitaDeleteResponse(id.getValue());
    }
}
