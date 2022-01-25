package com.prueba.consultorio.application.commons;

public class NonEmptyString {
    private final String value;

    public NonEmptyString(String value) {
        Validate.notNull(value, "NotEmptyString can not be null");
        Validate.isTrue(StringUtils.nonBlank(value), "NotEmptyString can not be empty");

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
