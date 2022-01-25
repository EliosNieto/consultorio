package com.prueba.consultorio.infraestructura.codec.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class NonEmptyUUIDCodecJson {

    public static class NonEmptyUUIDEncoder extends JsonSerializer<NonEmptyUUID> {

        @Override
        public void serialize(NonEmptyUUID value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(String.valueOf(value.getValue()));
        }
    }
}
