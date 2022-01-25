package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.ExamenClinico;

import java.util.List;
import java.util.Optional;

public interface ExamenClinicoRepository {

    public List<ExamenClinico> list();
    public Optional<ExamenClinico> save(ExamenClinico examenClinico);
    public Optional<ExamenClinico> findById(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);
}
