package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.CitaTipo;

import java.util.List;
import java.util.Optional;

public interface CitaTipoRepository {
    public List<CitaTipo> list();
    public Optional<CitaTipo> save (CitaTipo citaTipo);
    public  Optional<CitaTipo> findById(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);
}
