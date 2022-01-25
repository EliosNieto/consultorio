package com.prueba.consultorio.application.commons;

import java.util.UUID;

public class NonEmptyUUID {

    private UUID value;

    public NonEmptyUUID(String value){
        this.value = UUID.fromString(value);
    }


    public UUID getValue() {
        return value;
    }
}
