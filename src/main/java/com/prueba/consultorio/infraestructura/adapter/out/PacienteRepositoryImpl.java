package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;
import com.prueba.consultorio.infraestructura.persist.PacienteRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.PacienteEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.PacienteMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteRepositoryImpl implements PacienteRepositiry {

    private final PacienteRepositoryJpa pacienteRepositoryJpa;
    private final PacienteMapper pacienteMapper;

    public PacienteRepositoryImpl(PacienteRepositoryJpa pacienteRepositoryJpa, PacienteMapper pacienteMapper) {
        this.pacienteRepositoryJpa = pacienteRepositoryJpa;
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public List<Paciente> list() {
        return new ArrayList<>(pacienteMapper.toPacienteBuilds(pacienteRepositoryJpa.findAll()));
    }

    @Override
    public Optional<Paciente> save(Paciente paciente) {
        PacienteEntity pacienteEntity = pacienteMapper.toPacienteEntity(paciente);
        pacienteEntity = pacienteRepositoryJpa.save(pacienteEntity);
        return Optional.ofNullable(pacienteMapper.toPacienteBuild(pacienteEntity));
    }

    @Override
    public Optional<Paciente> findId(NonEmptyUUID id) {
        Optional<PacienteEntity> paciente = pacienteRepositoryJpa.findById(id.getValue());
        if(!paciente.isPresent()) {
            return Optional.empty();
        }
        return paciente.map(pacienteMapper::toPacienteBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        pacienteRepositoryJpa.deleteById(id.getValue());
    }
}
