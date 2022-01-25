package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Control;

import java.util.List;
import java.util.Optional;

public interface ControlRepository {

    public List<Control> list();
    public Optional<Control> save(Control control);
    public Optional<Control> findById(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);
}
