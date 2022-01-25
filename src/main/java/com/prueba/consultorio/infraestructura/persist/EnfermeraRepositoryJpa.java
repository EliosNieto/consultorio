package com.prueba.consultorio.infraestructura.persist;

import com.prueba.consultorio.infraestructura.persist.entity.EnfermeraEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnfermeraRepositoryJpa extends CrudRepository<EnfermeraEntity, UUID> {
}
