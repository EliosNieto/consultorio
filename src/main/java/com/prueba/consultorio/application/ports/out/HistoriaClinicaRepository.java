package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.HistoriaClinica;

import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaRepository {

    public List<HistoriaClinica> list();
    public Optional<HistoriaClinica> save(HistoriaClinica historiaClinica);
    public Optional<HistoriaClinica> findById(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);
}
