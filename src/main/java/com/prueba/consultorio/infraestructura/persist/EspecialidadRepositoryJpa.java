package com.prueba.consultorio.infraestructura.persist;

import com.prueba.consultorio.infraestructura.persist.entity.EspecialidadEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EspecialidadRepositoryJpa extends CrudRepository<EspecialidadEntity, UUID> {
}
