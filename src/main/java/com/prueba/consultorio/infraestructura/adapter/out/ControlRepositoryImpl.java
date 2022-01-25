package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Control;
import com.prueba.consultorio.application.ports.out.ControlRepository;
import com.prueba.consultorio.infraestructura.persist.ControlRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.ControlEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.ControlMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ControlRepositoryImpl implements ControlRepository {

    private final ControlRepositoryJpa controlRepositoryJpa;
    private final ControlMapper controlMapper;

    public ControlRepositoryImpl(ControlRepositoryJpa controlRepositoryJpa, ControlMapper controlMapper) {
        this.controlRepositoryJpa = controlRepositoryJpa;
        this.controlMapper = controlMapper;
    }

    @Override
    public List<Control> list() {
        return new ArrayList<>(controlMapper.toControlBuilds(controlRepositoryJpa.findAll()));
    }

    @Override
    public Optional<Control> save(Control control) {
        ControlEntity controlEntity = controlMapper.toControlEntity(control);
        controlEntity = controlRepositoryJpa.save(controlEntity);
        return Optional.ofNullable(controlMapper.toControlBuild(controlEntity));
    }

    @Override
    public Optional<Control> findById(NonEmptyUUID id) {
        Optional<ControlEntity> controlEntity = controlRepositoryJpa.findById(id.getValue());
        if (!controlEntity.isPresent()) {
            return Optional.empty();
        }
        return controlEntity.map(controlMapper::toControlBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        controlRepositoryJpa.deleteById(id.getValue());
    }
}
