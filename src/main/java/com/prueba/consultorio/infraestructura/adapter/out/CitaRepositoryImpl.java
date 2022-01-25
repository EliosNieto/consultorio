package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Cita;
import com.prueba.consultorio.application.ports.out.CitaRepository;
import com.prueba.consultorio.infraestructura.persist.CitaRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.CitaEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.CitaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaRepositoryImpl implements CitaRepository {

    Logger logger = LoggerFactory.getLogger(CitaRepositoryImpl.class);

    private final CitaRepositoryJpa citaRepositoryJpa;
    private final CitaMapper citaMapper;

    public CitaRepositoryImpl(CitaRepositoryJpa citaRepositoryJpa, CitaMapper citaMapper) {
        this.citaRepositoryJpa = citaRepositoryJpa;
        this.citaMapper = citaMapper;
    }

    @Override
    public List<Cita> list() {
        return new ArrayList<>(citaMapper.toCitaBuilds(citaRepositoryJpa.findAll()));
    }

    @Override
    public Optional<Cita> save(Cita cita) {
        logger.info(cita.toString());
        CitaEntity citaEntity = citaMapper.toCitaEntity(cita);
        logger.info(citaEntity.toString());
        citaEntity = citaRepositoryJpa.save(citaEntity);
        return Optional.ofNullable(citaMapper.toCitaBuild(citaEntity));
    }

    @Override
    public Optional<Cita> findById(NonEmptyUUID id) {
        Optional<CitaEntity> optionalCitaEntity = citaRepositoryJpa.findById(id.getValue());
        if(!optionalCitaEntity.isPresent()) {
            return Optional.empty();
        }
        return optionalCitaEntity.map(citaMapper::toCitaBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        citaRepositoryJpa.deleteById(id.getValue());
    }
}
