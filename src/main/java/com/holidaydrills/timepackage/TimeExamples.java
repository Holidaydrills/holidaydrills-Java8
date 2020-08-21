package com.holidaydrills.timepackage;

import java.time.*;

public class TimeExamples {

    public void instantiatingDates() {
        LocalDate dateNow = LocalDate.now();
        LocalDateTime dateTimeNow = LocalDateTime.now();

        LocalTime someTime = LocalTime.of(22, 55, 30);
        LocalDate someDate = LocalDate.of(1990, 10, 03);
        LocalDate againTheSameDate = LocalDate.of(1990, Month.APRIL, 03);
        // LocalDateTime with year, month, day, hour, minutes and seconds
        LocalDateTime someDateTime = LocalDateTime.of(1990, 10,03,22,55,30);
        LocalDateTime againTheSameDateTime = LocalDateTime.of(someDate, someTime);

        LocalDate dateFromString = LocalDate.parse("1990, 10, 03");

        LocalDate oneMoreDate = LocalDate.from(Instant.now());
    }
}
