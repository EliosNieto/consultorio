package com.prueba.consultorio.application.commons;

import java.time.LocalTime;

public class NonEmptyLocalTime {
    private final LocalTime value;

    public NonEmptyLocalTime(String value) {
        this.value = LocalTime.parse(value);
    }

    public LocalTime getValue() {
        return value;
    }
}
