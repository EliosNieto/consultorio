package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Cita;
import com.prueba.consultorio.application.errors.CitaIdNotFound;
import com.prueba.consultorio.application.models.cita.CitaFindByIdRequest;
import com.prueba.consultorio.application.models.cita.CitaFindByIdResponse;
import com.prueba.consultorio.application.ports.in.CitaFindByIdUseCase;
import com.prueba.consultorio.application.ports.out.CitaRepository;

import java.util.Optional;

public class CitaFindByIdService implements CitaFindByIdUseCase {

    private final CitaRepository citaRepository;

    public CitaFindByIdService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public CitaFindByIdResponse execute(CitaFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<Cita> optionalCita = citaRepository.findById(id);
        if (!optionalCita.isPresent()){
            throw new CitaIdNotFound(id);
        }
        return new CitaFindByIdResponse(optionalCita.get());
    }
}
