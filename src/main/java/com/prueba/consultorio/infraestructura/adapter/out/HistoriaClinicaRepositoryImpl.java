package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.HistoriaClinica;
import com.prueba.consultorio.application.ports.out.HistoriaClinicaRepository;
import com.prueba.consultorio.infraestructura.persist.HistoriaClinicaRepositoryJpa;
import com.prueba.consultorio.infraestructura.persist.entity.HistoriaClinicaEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.HistoriaClinicaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaRepositoryImpl implements HistoriaClinicaRepository {

    private final HistoriaClinicaRepositoryJpa historiaClinicaRepositoryJpa;
    private final HistoriaClinicaMapper historiaClinicaMapper;

    public HistoriaClinicaRepositoryImpl(HistoriaClinicaRepositoryJpa historiaClinicaRepositoryJpa, HistoriaClinicaMapper historiaClinicaMapper) {
        this.historiaClinicaRepositoryJpa = historiaClinicaRepositoryJpa;
        this.historiaClinicaMapper = historiaClinicaMapper;
    }

    @Override
    public List<HistoriaClinica> list() {
        return new ArrayList<>(historiaClinicaMapper.toHistoriaClinicaBuilds(historiaClinicaRepositoryJpa.findAll()));
    }

    @Override
    public Optional<HistoriaClinica> save(HistoriaClinica historiaClinica) {
        HistoriaClinicaEntity historiaClinicaEntity = historiaClinicaMapper.toHistoriaClinica(historiaClinica);
        historiaClinicaEntity = historiaClinicaRepositoryJpa.save(historiaClinicaEntity);
        return Optional.ofNullable(historiaClinicaMapper.toHistoriaClinicaBuild(historiaClinicaEntity));
    }

    @Override
    public Optional<HistoriaClinica> findById(NonEmptyUUID id) {
        Optional<HistoriaClinicaEntity> optionalHistoriaClinica = historiaClinicaRepositoryJpa.findById(id.getValue());
        if (!optionalHistoriaClinica.isPresent()) {
            return Optional.empty();
        }
        return optionalHistoriaClinica.map(historiaClinicaMapper::toHistoriaClinicaBuild);
    }

    @Override
    public void delete(NonEmptyUUID id) {
        historiaClinicaRepositoryJpa.deleteById(id.getValue());
    }
}
