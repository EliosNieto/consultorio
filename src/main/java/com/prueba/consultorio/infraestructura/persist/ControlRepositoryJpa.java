package com.prueba.consultorio.infraestructura.persist;

import com.prueba.consultorio.infraestructura.persist.entity.ControlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ControlRepositoryJpa extends CrudRepository<ControlEntity, UUID> {
}
