package com.prueba.consultorio.infraestructura.codec.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class NonEmptyLocalTimeCodecJson {
    public static class NonEmptyLocalTimeEncoder extends JsonSerializer<NonEmptyLocalTime> {

        @Override
        public void serialize(NonEmptyLocalTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeObject(value.getValue());
        }
    }
}
