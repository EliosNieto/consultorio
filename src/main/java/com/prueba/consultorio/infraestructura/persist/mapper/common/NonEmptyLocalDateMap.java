package com.prueba.consultorio.infraestructura.persist.mapper.common;

import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import org.mapstruct.Mapper;

import java.time.LocalDate;


@Mapper(componentModel = "spring")
public class NonEmptyLocalDateMap {

    public LocalDate map(NonEmptyLocalDate date){
        return date.getValue();
    }

    public NonEmptyLocalDate map(LocalDate id){
        return new NonEmptyLocalDate(id.toString());
    }
}
