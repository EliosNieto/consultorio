package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Enfermera;
import com.prueba.consultorio.application.ports.out.EnfermeraRepository;
import com.prueba.consultorio.infraestructura.persist.EnfermeraRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.EnfermeraEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.EnfermeraMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnfermeraRepositoryImpl implements EnfermeraRepository {

    private final Logger logger = LoggerFactory.getLogger(EnfermeraRepositoryImpl.class);

    private final EnfermeraRepositoryJpa enfermeraRepositoryJpa;
    private final EnfermeraMapper enfermeraMapper;

    public EnfermeraRepositoryImpl(EnfermeraRepositoryJpa enfermeraRepositoryJpa, EnfermeraMapper enfermeraMapper) {
        this.enfermeraRepositoryJpa = enfermeraRepositoryJpa;
        this.enfermeraMapper = enfermeraMapper;
    }

    @Override
    public List<Enfermera> list() {
        return enfermeraMapper.toEnfermeras(enfermeraRepositoryJpa.findAll()).stream().map(enfermeraBuild -> {
            logger.info(enfermeraBuild.toString());
            return new Enfermera(enfermeraBuild.getIdFermera(), enfermeraBuild.getTipoDocumento(),enfermeraBuild.getNumero(), enfermeraBuild.getNombres());
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Enfermera> save(Enfermera enfermera) {
        EnfermeraEntity enfermeraEntity = enfermeraMapper.toEnfermera(enfermera);
        EnfermeraEntity save = enfermeraRepositoryJpa.save(enfermeraEntity);
        return Optional.ofNullable(enfermeraMapper.toEnfermera(save));
    }

    @Override
    public Optional<Enfermera> findById(NonEmptyUUID id) {
        Optional<EnfermeraEntity> enfermeraEntity = enfermeraRepositoryJpa.findById(id.getValue());
        if(!enfermeraEntity.isPresent()) {
            return Optional.empty();
        }
        return enfermeraEntity.map(enfermeraMapper::toEnfermera);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        Optional<EnfermeraEntity> enfermeraEntity = enfermeraRepositoryJpa.findById(id.getValue());
        enfermeraRepositoryJpa.delete(enfermeraEntity.get());
    }
}
