package com.airpremia.eosh.config.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    private static final DateTimeFormatter PRINT_LOCAL_DATE_FORMATER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @Override
    public void serialize(
        LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(PRINT_LOCAL_DATE_FORMATER.format(localDateTime.atZone(ZoneId.of("UTC"))));
    }
}
