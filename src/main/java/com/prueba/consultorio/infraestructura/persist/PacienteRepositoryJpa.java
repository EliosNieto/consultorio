package com.prueba.consultorio.infraestructura.persist;

import com.prueba.consultorio.infraestructura.persist.entity.PacienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacienteRepositoryJpa extends CrudRepository<PacienteEntity, UUID> {
}
