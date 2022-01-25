package com.prueba.consultorio.infraestructura.persist.mapper.common;

import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import org.mapstruct.Mapper;

import java.time.LocalTime;


@Mapper(componentModel = "spring")
public class NonEmptyLocalTimeMap {

    public LocalTime map(NonEmptyLocalTime time){
        return time.getValue();
    }

    public NonEmptyLocalTime map(LocalTime time){
        return new NonEmptyLocalTime(time.toString());
    }
}
