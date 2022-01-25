package com.prueba.consultorio.infraestructura.persist;

import com.prueba.consultorio.infraestructura.persist.entity.HistoriaClinicaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface HistoriaClinicaRepositoryJpa extends CrudRepository<HistoriaClinicaEntity, UUID> {
}
