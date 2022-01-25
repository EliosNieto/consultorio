package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;
import com.prueba.consultorio.application.ports.out.EspecialidadRepository;
import com.prueba.consultorio.infraestructura.persist.EspecialidadRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.EspecialidadEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.EspecialidadMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecialidadRepositoryImpl implements EspecialidadRepository {

    private final EspecialidadRepositoryJpa especialidadRepositoryJpa;
    private final EspecialidadMapper especialidadMapper;

    public EspecialidadRepositoryImpl(EspecialidadRepositoryJpa especialidadRepositoryJpa, EspecialidadMapper especialidadMapper) {
        this.especialidadRepositoryJpa = especialidadRepositoryJpa;
        this.especialidadMapper = especialidadMapper;
    }

    @Override
    public List<MedicoEspecialidad> list() {
        return especialidadMapper.toEspecialidadBuilds(especialidadRepositoryJpa.findAll()).stream().map(especialidadBuild -> {
            return new MedicoEspecialidad(especialidadBuild.getId(), especialidadBuild.getNombres());
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<MedicoEspecialidad> save(MedicoEspecialidad medicoEspecialidad) {
        EspecialidadEntity especialidadEntity = especialidadMapper.toEspecialidadEntity(medicoEspecialidad);
        especialidadEntity = especialidadRepositoryJpa.save(especialidadEntity);
        return Optional.ofNullable(especialidadMapper.toEspecialidadBuild(especialidadEntity));
    }

    @Override
    public Optional<MedicoEspecialidad> findById(NonEmptyUUID id) {
        Optional<EspecialidadEntity> especialidad = especialidadRepositoryJpa.findById(id.getValue());
        if(!especialidad.isPresent()) {
            return Optional.empty();
        }
        return especialidad.map(especialidadMapper::toEspecialidadBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        especialidadRepositoryJpa.deleteById(id.getValue());
    }
}
