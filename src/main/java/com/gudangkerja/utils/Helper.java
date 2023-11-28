package com.gudangkerja.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Formatter;
import java.util.Locale;

public class Helper {

    public static String toStringInstant(Instant instant){
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(Locale.ROOT)
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
    }


}
