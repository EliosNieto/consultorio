package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.HistoriaClinica;
import com.prueba.consultorio.application.errors.HistoriaClinicaIdNotFound;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaFindByIdRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaFindByIdResponse;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaListRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaListResponse;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaListUseCase;
import com.prueba.consultorio.application.ports.out.HistoriaClinicaRepository;

import java.util.Optional;

public class HistoriaClinicaFindByIdService implements HistoriaClinicaFindByIdUseCase {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinicaFindByIdService(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public HistoriaClinicaFindByIdResponse execute(HistoriaClinicaFindByIdRequest request) {
        NonEmptyUUID id = Validate.nonEmptyUUID("id", request.getId());
        Optional<HistoriaClinica> optionalHistoriaClinica = historiaClinicaRepository.findById(id);
        if(!optionalHistoriaClinica.isPresent()){
            throw new HistoriaClinicaIdNotFound(id);
        }
        return new HistoriaClinicaFindByIdResponse(optionalHistoriaClinica.get());
    }
}
