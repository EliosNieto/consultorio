package com.prueba.consultorio.infraestructura.codec.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.prueba.consultorio.application.commons.NonEmptyString;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class NonEmptyStringCodecJson {
    public static class NonEmptyStringEncoder extends JsonSerializer<NonEmptyString> {

        @Override
        public void serialize(NonEmptyString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.getValue());
        }
    }
}
