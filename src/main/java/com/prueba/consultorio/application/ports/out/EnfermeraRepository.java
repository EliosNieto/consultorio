package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Enfermera;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnfermeraRepository {

    public List<Enfermera> list();

    public Optional<Enfermera> save (Enfermera enfermera);

    public Optional<Enfermera>findById(NonEmptyUUID id);

    public void delete(NonEmptyUUID id);
}
