package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.CitaTipo;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;
import com.prueba.consultorio.infraestructura.persist.CitaTipoRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.CitaTipoEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.CitaTipoMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaTipoRepositoryImpl implements CitaTipoRepository {

    private final CitaTipoRepositoryJpa citaTipoRepositoryJpa;
    private final CitaTipoMapper citaTipoMapper;

    public CitaTipoRepositoryImpl(CitaTipoRepositoryJpa citaTipoRepositoryJpa, CitaTipoMapper citaTipoMapper) {
        this.citaTipoRepositoryJpa = citaTipoRepositoryJpa;
        this.citaTipoMapper = citaTipoMapper;
    }

    @Override
    public List<CitaTipo> list() {
        return new ArrayList<>(citaTipoMapper.toCitaTipoBuilds(citaTipoRepositoryJpa.findAll()));
    }

    @Override
    public Optional<CitaTipo> save(CitaTipo citaTipo) {
        CitaTipoEntity citaTipoEntity = citaTipoMapper.toCitaTipoEntity(citaTipo);
        citaTipoEntity = citaTipoRepositoryJpa.save(citaTipoEntity);
        return Optional.ofNullable(citaTipoMapper.toCitaTipoBuild(citaTipoEntity));
    }

    @Override
    public Optional<CitaTipo> findById(NonEmptyUUID id) {
        Optional<CitaTipoEntity> optionalCitaTipo = citaTipoRepositoryJpa.findById(id.getValue());
        if(!optionalCitaTipo.isPresent()) {
            return Optional.empty();
        }
        return optionalCitaTipo.map(citaTipoMapper::toCitaTipoBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        citaTipoRepositoryJpa.deleteById(id.getValue());
    }
}
