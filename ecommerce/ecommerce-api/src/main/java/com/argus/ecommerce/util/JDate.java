package com.argus.ecommerce.util;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DayOfWeek;

public class JDate {
    public static LocalDate getToday() {
        return LocalDate.now();
    }

    public static LocalTime getTime() {
        return LocalTime.now();
    }

    public static LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }

    public LocalDate createDate(int year, int month, int date) {
        return LocalDate.of(year, month, date);
    }

    public Boolean isWeekend(LocalDateTime date) {
        if (date.getDayOfWeek().getValue() > DayOfWeek.FRIDAY.getValue()) {
            return true;
        }
        return false;
    }

    public Boolean isWeekday(LocalDateTime date) {
        return !isWeekend(date);
    }

    public LocalDateTime getPreviousDay(LocalDateTime date) {
        return date.minusDays(1);
    }

    public LocalDateTime getPreviousWeekDay(LocalDateTime date) {
        while (true) {
            LocalDateTime previousDay = date.minusDays(1);
            if (isWeekday(previousDay)) {
                return previousDay;
            }
        }
    }
}