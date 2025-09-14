package com.spaceadvisor.utilities;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateFormatter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private DateFormatter() {}

    public static LocalDate convert(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    public static String getDay(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }

    public static String getMonthName(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static String getMonthNumber(String monthName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
        return String.valueOf(Month.from(formatter.parse(monthName)).getValue());
    }

    public static String getYear(LocalDate date) {
        return String.valueOf(date.getYear());
    }

    public static String formatRange(LocalDate departure, LocalDate returning) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM d", Locale.ENGLISH);
        return fmt.format(departure) + " – " + fmt.format(returning);
    }

}
