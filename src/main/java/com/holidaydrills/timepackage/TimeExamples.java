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

    public void operationsOnDates() {
        LocalDateTime localDateTime = LocalDateTime.of(1990, 10,03,22,55,30);

        LocalDateTime newLocalDateTime = localDateTime.plusYears(2);
        //localDate is not changed, only the return value reflect the change
        System.out.println(localDateTime); // 1990-10-03T22:55:30
        System.out.println(newLocalDateTime); // 1992-10-03T22:55:30

        newLocalDateTime = localDateTime.plusMonths(1);
        System.out.println(newLocalDateTime); // 1990-11-03T22:55:30

        newLocalDateTime = localDateTime.plusDays(5);
        System.out.println(newLocalDateTime); // 1990-11-08T22:55:30

        newLocalDateTime = localDateTime.minusHours(7);
        System.out.println(newLocalDateTime); // 1990-10-03T15:55:30

        newLocalDateTime = localDateTime.plusMinutes(1);
        System.out.println(newLocalDateTime); // 1990-11-08T23:56:30

        newLocalDateTime = localDateTime.plusSeconds(10);
        System.out.println(newLocalDateTime); // 1990-11-08T23:55:40

        // Method chaining
        newLocalDateTime = localDateTime.plusYears(2).plusMonths(1).plusDays(5).minusHours(7).plusMinutes(1).plusSeconds(10);
        System.out.println(newLocalDateTime); // 1992-11-08T15:56:40
    }

    public void timeZones() {
        System.out.println(ZoneId.getAvailableZoneIds()); //[Asia/Aden, America/Cuiaba, Etc/GMT+9, Etc/GMT+8, Africa/Nairobi, ...]

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("Europe/Brussels"));
        System.out.println(zonedDateTime); // 2020-08-25T08:26:46.648786+02:00[Europe/Brussels]
    }
}
