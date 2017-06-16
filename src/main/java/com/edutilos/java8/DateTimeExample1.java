package com.edutilos.java8;

import java.time.*;
import java.time.chrono.Era;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by edutilos on 16.06.17.
 */
public class DateTimeExample1 {
    public static void main(String[] args) {
      legacyTest3();
    }

    private static final String newline = "\r\n";



    private static void interopTest() {
        GregorianCalendar gc = new GregorianCalendar();
        ZonedDateTime zdt = gc.toZonedDateTime();
        LocalDate ld  = gc.toZonedDateTime().toLocalDate();
        LocalDateTime ldt = gc.toZonedDateTime().toLocalDateTime();
        OffsetDateTime odt = gc.toZonedDateTime().toOffsetDateTime();

        GregorianCalendar gc2 = GregorianCalendar.from(ZonedDateTime.now());

        Date date = new Date();
        Instant in = date.toInstant();
        Date date2 = Date.from(in);
    }

    private static void legacyTest3() {
     GregorianCalendar gc = new GregorianCalendar();
     int year = gc.get(GregorianCalendar.YEAR),
             month = gc.get(GregorianCalendar.MONTH),
             day = gc.get(GregorianCalendar.DAY_OF_MONTH),
             dayOfYear = gc.get(GregorianCalendar.DAY_OF_YEAR),
             dayOfWeek = gc.get(GregorianCalendar.DAY_OF_WEEK),
             hour = gc.get(GregorianCalendar.HOUR),
             min = gc.get(GregorianCalendar.MINUTE),
             sec = gc.get(GregorianCalendar.SECOND),
             ms = gc.get(GregorianCalendar.MILLISECOND);

     StringBuilder sb = new StringBuilder();
     sb.append("year = ").append(year).append(newline)
             .append("month = ").append(month).append(newline)
             .append("day = ").append(day).append(newline)
             .append("dayOfYear = ").append(dayOfYear).append(newline)
             .append("dayOfWeek = ").append(dayOfWeek).append(newline)
             .append("hour = ").append(hour).append(newline)
             .append("min = ").append(min).append(newline)
             .append("sec = ").append(sec).append(newline)
             .append("ms = ").append(ms).append(newline)
             .append(newline);
        System.out.println(sb.toString());

        gc.add(GregorianCalendar.YEAR, 1);
        gc.add(GregorianCalendar.MONTH, 1);
        gc.add(GregorianCalendar.DAY_OF_MONTH, 1);
        System.out.println(gc.getTime().toString());
    }

    private static void legacyTest2() {
        GregorianCalendar gc = new GregorianCalendar(1991, 10 ,10 ,10, 10);
        GregorianCalendar now = new GregorianCalendar();
        System.out.println(String.format("gc = %s", gc.getTime().toString()));
        System.out.println(String.format("now = %s", now.getTime().toString()));
        GregorianCalendar gcTZ = new GregorianCalendar(TimeZone.getTimeZone("GMT+03:00"));
        System.out.println(String.format("gcTZ = %s", gcTZ.getTime().toString()));
    }

    private static void legacyTest1() {
        Date date = new Date();
        System.out.println(String.format("current date = %s", date.toString()));
        long millis = date.getTime();
        System.out.println(String.format("Millis = %d", millis));
    }

    private static void test3() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate ld = LocalDate.parse("2016/01/01", formatter);
        System.out.println(ld);
        LocalDate tempLd = formatter.parse("2016/01/01", LocalDate::from);
        System.out.println(tempLd);
    }

    private static void test2() {
        DateTimeFormatter [] formatters  = {
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_OFFSET_DATE,
                DateTimeFormatter.ISO_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_OFFSET_TIME,
                DateTimeFormatter.ISO_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                DateTimeFormatter.ISO_OFFSET_DATE_TIME,
                DateTimeFormatter.ISO_ZONED_DATE_TIME,
                DateTimeFormatter.ISO_DATE_TIME,
                DateTimeFormatter.ISO_ORDINAL_DATE,
                DateTimeFormatter.ISO_WEEK_DATE,
                DateTimeFormatter.ISO_INSTANT,
                DateTimeFormatter.BASIC_ISO_DATE,
                DateTimeFormatter.RFC_1123_DATE_TIME
        };
        /*
        DateTimeFormatter.PARSED_EXCESS_DAYS
        DateTimeFormatter.PARSED_LEAP_SECOND*/

        ZonedDateTime zdt = ZonedDateTime.now();
        for(DateTimeFormatter formatter: formatters) {
            System.out.println(formatter.format(zdt));
        }
        System.out.println();
        System.out.println(zdt.format(formatters[2]));

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("y/M/d");
        System.out.println(zdt.format(customFormatter));

        customFormatter = new DateTimeFormatterBuilder()
                .appendLiteral("I was born in Year ")
                .appendValue(ChronoField.YEAR)
                .appendLiteral(", in Month ")
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(", on Day ")
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(", on week ")
                .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
                .toFormatter();

        System.out.println(zdt.format(customFormatter));


        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.GERMAN);
        System.out.println(zdt.format(formatter));
    }

    private static void test1() {
        LocalDate now = LocalDate.now();
        printLocalDate(now);
       LocalDateTime ldt = LocalDateTime.now();
       printLocalDateTime(ldt);
       LocalTime lt = LocalTime.now();
       printLocalTime(lt);



       LocalDate ld = LocalDate.of(1991, 10 , 10);
       ld = LocalDate.ofYearDay(now.getYear(), now.getDayOfYear());
       ld = LocalDate.ofEpochDay(2014);
        System.out.println(ld);

        ld = LocalDate.from(ldt);

        LocalDate tempLd = ld.with(ChronoField.YEAR , 2020)
                .with(ChronoField.MONTH_OF_YEAR, 9)
                .with(ChronoField.DAY_OF_MONTH, 11);

        tempLd = ld.with(now);
        tempLd = ld.withDayOfMonth(11)
                .withDayOfYear(191)
                .withMonth(10)
                .withYear(1975);


        IsoChronology chronology = tempLd.getChronology();
         Era era = tempLd.getEra();
        System.out.println(chronology.toString());
        System.out.println(era.toString());

        int dayOfMonth = tempLd.getDayOfMonth();
        DayOfWeek dayOfWeek = tempLd.getDayOfWeek();
        int dayOfYear = tempLd.getDayOfYear();
        int year = tempLd.getYear();
        Month month = tempLd.getMonth();
        int monthValue = tempLd.getMonthValue();
        System.out.println(month.getDisplayName(TextStyle.FULL, Locale.US));
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US));

        System.out.println(month.getDisplayName(TextStyle.FULL, Locale.GERMAN));
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.GERMAN));

        System.out.println(ld.toEpochDay());
        System.out.println(ld.toString());
        LocalDateTime tempLdt  = ld.atStartOfDay();
        tempLdt = ld.atTime(LocalTime.of(10, 10, 10));
        tempLdt = ld.atTime(10 , 10 );
        tempLdt = ld.atTime(10 , 10 , 10);

        tempLd = Year.of(1991).atMonth(Month.DECEMBER).atDay(8);
        System.out.println(tempLd);

        tempLd = ld.plus(Period.ofYears(1))
                .plus(Period.ofMonths(1))
                .plus(Period.ofDays(1));

        tempLd = ld.plus(Period.ofYears(1).ofMonths(1).ofDays(1));

        tempLd = ld.plusDays(1)
                .plusMonths(1)
                .plusWeeks(1)
                .plusYears(1);

        tempLd = ld.minus(Period.ofYears(1))
                .minus(Period.ofMonths(1))
                .minus(Period.ofDays(1));

        tempLd = ld.minus(Period.ofYears(1).ofMonths(1).ofDays(1));
        tempLd = ld.minusDays(1)
                .minusMonths(1)
                .minusWeeks(1)
                .minusYears(1);

        ZonedDateTime zdt = ZonedDateTime.now();
        ZonedDateTime tempZdt = ZonedDateTime.of(LocalDate.now(),
                LocalTime.now(), ZoneId.of("UTC"));
        System.out.println(tempZdt);

        tempZdt = ZonedDateTime.of(1991, 10, 10 , 10, 10, 10, 10, ZoneId.of("GMT"));
        System.out.println(tempZdt);
    }




    private static void printLocalTime(LocalTime lt) {
       int hour = lt.get(ChronoField.HOUR_OF_DAY),
               min = lt.get(ChronoField.MINUTE_OF_HOUR),
               sec = lt.get(ChronoField.SECOND_OF_MINUTE),
               ms = lt.get(ChronoField.MILLI_OF_SECOND);

       StringBuilder sb = new StringBuilder();
       sb.append("hour = ").append(hour).append(newline)
               .append("min = ").append(min).append(newline)
               .append("sec = ").append(sec).append(newline)
               .append("ms = ").append(ms).append(newline)
               .append(newline);

        System.out.println(sb.toString());
    }

    private static void printLocalDateTime(LocalDateTime ldt) {
        int year = ldt.get(ChronoField.YEAR),
                month = ldt.get(ChronoField.MONTH_OF_YEAR),
                day = ldt.get(ChronoField.DAY_OF_MONTH),
                weekDay = ldt.get(ChronoField.DAY_OF_WEEK),
                yearDay = ldt.get(ChronoField.DAY_OF_YEAR),
                hour = ldt.get(ChronoField.HOUR_OF_DAY),
                min = ldt.get(ChronoField.MINUTE_OF_HOUR),
                sec = ldt.get(ChronoField.SECOND_OF_MINUTE),
                ms = ldt.get(ChronoField.MILLI_OF_SECOND);

        StringBuilder sb = new StringBuilder();
        sb.append("year = ").append(year).append(newline)
                .append("month = ").append(month).append(newline)
                .append("day = ").append(day).append(newline)
                .append("weekDay = ").append(weekDay).append(newline)
                .append("yearDay = ").append(yearDay).append(newline)
                .append("hour = ").append(hour).append(newline)
                .append("min = ").append(min).append(newline)
                .append("sec = ").append(sec).append(newline)
                .append("ms = ").append(ms).append(newline)
                .append(newline);

        System.out.println(sb.toString());
    }

    private static void printLocalDate(LocalDate ld) {
        int year = ld.get(ChronoField.YEAR),
                month = ld.get(ChronoField.MONTH_OF_YEAR),
                day = ld.get(ChronoField.DAY_OF_MONTH),
                weekDay = ld.get(ChronoField.DAY_OF_WEEK),
                yearDay = ld.get(ChronoField.DAY_OF_YEAR);
        StringBuilder sb = new StringBuilder();
        sb.append("Year = ").append(year).append(newline)
                .append("Month = ").append(month).append(newline)
                .append("Day = ").append(day).append(newline)
                .append("WeekDay = ").append(weekDay).append(newline)
                .append("YearDay = ").append(yearDay).append(newline)
                .append(newline);

        System.out.println(sb.toString());
    }
}
