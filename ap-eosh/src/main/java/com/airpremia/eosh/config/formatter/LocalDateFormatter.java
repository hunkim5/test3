package com.airpremia.eosh.config.formatter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

public class LocalDateFormatter implements Formatter<LocalDate> {
    private static final DateTimeFormatter ISO_8601_FORMATER = DateTimeFormatter.ISO_ZONED_DATE_TIME;
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final DateTimeFormatter LOCAL_DATE_FORMATER = DateTimeFormatter.ISO_LOCAL_DATE;

    private static final DateTimeFormatter PRINT_LOCAL_DATE_FORMATER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @Override
    public LocalDate parse(String text, Locale locale) {
        if (text == null || text.length() == 0) {
            return null;
        } else if (text.length() >= 20) {
            return ZonedDateTime.parse(text, ISO_8601_FORMATER)
                .toLocalDate();
        } else if (text.length() == 19) {
            return LocalDate.parse(text, LOCAL_DATE_TIME_FORMATER);
        } else {
            return LocalDate.parse(text, LOCAL_DATE_FORMATER);
        }
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return PRINT_LOCAL_DATE_FORMATER.format(object.atStartOfDay().atZone(ZoneId.systemDefault()));
    }

}
