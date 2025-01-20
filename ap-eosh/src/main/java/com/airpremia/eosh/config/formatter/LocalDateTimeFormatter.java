package com.airpremia.eosh.config.formatter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    private static final DateTimeFormatter ISO_8601_FORMATER = DateTimeFormatter.ISO_DATE_TIME;
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final DateTimeFormatter PRINT_LOCAL_DATE_TIME_FORMATER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @Override
    public LocalDateTime parse(String text, Locale locale) {
        if (text == null || text.length() == 0) {
            return null;
        } else if (text.length() >= 20) {
            return ZonedDateTime.parse(text, ISO_8601_FORMATER)
                .toLocalDateTime();
        } else {
            return LocalDateTime.parse(text, LOCAL_DATE_TIME_FORMATER);
        }
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return PRINT_LOCAL_DATE_TIME_FORMATER.format(object.atZone(ZoneId.systemDefault()));
    }
}
