package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.ports.out.MedicoRepository;
import com.prueba.consultorio.infraestructura.persist.MedicoRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.MedicoEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.MedicoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoRepositoryImpl implements MedicoRepository {

    private Logger logger = LoggerFactory.getLogger(MedicoRepositoryImpl.class);

    private final MedicoRepositoryJpa medicoRepositoryJpa;
    private final MedicoMapper medicoMapper;

    public MedicoRepositoryImpl(MedicoRepositoryJpa medicoRepositoryJpa, MedicoMapper medicoMapper) {
        this.medicoRepositoryJpa = medicoRepositoryJpa;
        this.medicoMapper = medicoMapper;
    }

    @Override
    public List<Medico> list() {
        return new ArrayList<>(medicoMapper.toMedicoBuilds(medicoRepositoryJpa.findAll()));
    }

    @Override
    public Optional<Medico> save(Medico medico) {
        logger.info(medico.toString());
        MedicoEntity medicoEntity = medicoMapper.toMedicoEntity(medico);
        logger.info(medicoEntity.toString());
        medicoEntity = medicoRepositoryJpa.save(medicoEntity);
        logger.info(medicoEntity.toString());
        return Optional.ofNullable(medicoMapper.toMedicoBuild(medicoEntity));
    }

    @Override
    public Optional<Medico> findById(NonEmptyUUID id) {
        Optional<MedicoEntity> optionalMedico = medicoRepositoryJpa.findById(id.getValue());
        if(!optionalMedico.isPresent()){
            return Optional.empty();
        }

        return optionalMedico.map(medicoMapper::toMedicoBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        Optional<MedicoEntity> optionalMedico = medicoRepositoryJpa.findById(id.getValue());
        medicoRepositoryJpa.delete(optionalMedico.get());
    }
}
