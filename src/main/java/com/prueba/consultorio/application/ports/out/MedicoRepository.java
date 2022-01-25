package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository {
    public List<Medico> list();
    public Optional<Medico> save(Medico medico);
    public Optional<Medico> findById(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);
}
