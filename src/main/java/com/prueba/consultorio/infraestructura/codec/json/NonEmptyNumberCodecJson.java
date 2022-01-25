package com.prueba.consultorio.infraestructura.codec.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.prueba.consultorio.application.commons.NonEmptyNumber;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class NonEmptyNumberCodecJson {
    public static class NonEmptyNumberEncoder extends JsonSerializer<NonEmptyNumber> {

        @Override
        public void serialize(NonEmptyNumber value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.getValue());
        }
    }
}
