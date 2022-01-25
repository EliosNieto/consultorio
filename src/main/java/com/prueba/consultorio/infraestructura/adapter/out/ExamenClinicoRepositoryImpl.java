package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.ExamenClinico;
import com.prueba.consultorio.application.ports.out.ExamenClinicoRepository;
import com.prueba.consultorio.infraestructura.persist.ExamenClinicoRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.ExamenClinicoEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.ExamenClinicoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamenClinicoRepositoryImpl implements ExamenClinicoRepository {

    private final ExamenClinicoRepositoryJpa examenClinicoRepositoryJpa;
    private final ExamenClinicoMapper examenClinicoMapper;

    public ExamenClinicoRepositoryImpl(ExamenClinicoRepositoryJpa examenClinicoRepositoryJpa, ExamenClinicoMapper examenClinicoMapper) {
        this.examenClinicoRepositoryJpa = examenClinicoRepositoryJpa;
        this.examenClinicoMapper = examenClinicoMapper;
    }

    @Override
    public List<ExamenClinico> list() {
        return new ArrayList<>(examenClinicoMapper.toExamenClinicoBuild(examenClinicoRepositoryJpa.findAll()));
    }

    @Override
    public Optional<ExamenClinico> save(ExamenClinico examenClinico) {
        ExamenClinicoEntity examenClinicoEntity = examenClinicoMapper.toExamenClinicoEntity(examenClinico);
        examenClinicoEntity = examenClinicoRepositoryJpa.save(examenClinicoEntity);
        return Optional.ofNullable(examenClinico);
    }

    @Override
    public Optional<ExamenClinico> findById(NonEmptyUUID id) {
        Optional<ExamenClinicoEntity> optionalExamenClinicoEntity = examenClinicoRepositoryJpa.findById(id.getValue());
        if (!optionalExamenClinicoEntity.isPresent()) {
            return Optional.empty();
        }
        return optionalExamenClinicoEntity.map(examenClinicoMapper::toExamenClinicoBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        examenClinicoRepositoryJpa.deleteById(id.getValue());
    }
}
