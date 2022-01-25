package com.prueba.consultorio.infraestructura.persist.mapper.common;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public class NonEmptyStringMap {

    public String map(NonEmptyString id){
        return id.getValue();
    }

    public NonEmptyString map(String id){
        return new NonEmptyString(id.toString());
    }
}
