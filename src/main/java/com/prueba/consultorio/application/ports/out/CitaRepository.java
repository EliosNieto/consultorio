package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaRepository {
    public List<Cita> list();
    public Optional<Cita> save(Cita citaTipo);
    public Optional<Cita> findById(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);
}
