package com.prueba.consultorio.application.ports.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteRepositiry {

    public List<Paciente> list();
    public Optional<Paciente> save(Paciente paciente);
    public Optional<Paciente> findId(NonEmptyUUID id);
    public void delete(NonEmptyUUID id);
}
