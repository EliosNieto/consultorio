package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.HistoriaClinica;
import com.prueba.consultorio.application.errors.HistoriaClinicaIdNotFound;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaDeleteRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaDeleteResponse;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaDeleteUseCase;
import com.prueba.consultorio.application.ports.out.HistoriaClinicaRepository;

import java.util.Optional;

public class HistoriaClinicaDeleteService implements HistoriaClinicaDeleteUseCase {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinicaDeleteService(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public HistoriaClinicaDeleteResponse execute(HistoriaClinicaDeleteRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<HistoriaClinica> optionalHistoriaClinica = historiaClinicaRepository.findById(id);
        if(!optionalHistoriaClinica.isPresent()){
            throw new HistoriaClinicaIdNotFound(id);
        }
        return new HistoriaClinicaDeleteResponse(id.getValue());
    }
}
