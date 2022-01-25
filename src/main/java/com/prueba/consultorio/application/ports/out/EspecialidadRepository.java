package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadRepository {

    public List<MedicoEspecialidad> list();
    public Optional<MedicoEspecialidad> save(MedicoEspecialidad medicoEspecialidad);
    public Optional<MedicoEspecialidad> findById(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);

}
