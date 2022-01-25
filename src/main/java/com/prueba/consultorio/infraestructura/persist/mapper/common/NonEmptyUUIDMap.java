package com.prueba.consultorio.infraestructura.persist.mapper.common;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public class NonEmptyUUIDMap {

    public UUID map(NonEmptyUUID id){
        return id.getValue();
    }

    public NonEmptyUUID map(UUID id){
        return new NonEmptyUUID(id.toString());
    }
}
