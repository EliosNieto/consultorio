package com.prueba.consultorio.application.commons;

import java.time.LocalDate;

public class NonEmptyLocalDate {
    private final LocalDate value;

    public NonEmptyLocalDate(String value) {
        this.value = LocalDate.parse(value);
    }

    public LocalDate getValue() {
        return value;
    }
}
