package com.prueba.consultorio.infraestructura.persist;

import com.prueba.consultorio.infraestructura.persist.entity.CitaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CitaRepositoryJpa extends CrudRepository<CitaEntity, UUID> {
}
