package com.prueba.consultorio.application.commons;

public class NonEmptyNumber {
    private final Integer value;

    public NonEmptyNumber(String value) {
        this.value = NumbersUtil.toInteger(value);
    }

    public Integer getValue() {
        return value;
    }
}
