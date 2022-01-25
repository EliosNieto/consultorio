package com.prueba.consultorio.infraestructura.codec.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class NonEmptyLocalDateCodecJson {
    public static class NonEmptyLocalDateEncoder extends JsonSerializer<NonEmptyLocalDate> {

        @Override
        public void serialize(NonEmptyLocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeObject(value.getValue());
        }
    }
}
