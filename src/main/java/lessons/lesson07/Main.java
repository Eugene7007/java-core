package lessons.lesson07;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zoned = ZonedDateTime.now();
        Instant instant = Instant.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zoned);
        System.out.println(instant);


    }

    private static void parse() {
        LocalDateTime now = LocalDateTime.now();

        // Форматирование
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formatted = now.format(fmt);
        System.out.println(formatted); // 08.10.2025 13:50:10

        // Парсинг
        String input = "2025-12-25 18:30";
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(input, parser);
        System.out.println(dateTime); // 2025-12-25T18:30
    }

    private static void timezone() {
        ZoneId tashkent = ZoneId.of("Asia/Tashkent");
        ZoneId london = ZoneId.of("Europe/London");

        ZonedDateTime nowInTashkent = ZonedDateTime.now(tashkent);
        ZonedDateTime nowInLondon = nowInTashkent.withZoneSameInstant(london);

        System.out.println(nowInTashkent); // 2025-10-08T13:50+05:00[Asia/Tashkent]
        System.out.println(nowInLondon);   // 2025-10-08T09:50+01:00[Europe/London]
    }

    private static void period() {
        LocalDate start = LocalDate.of(2020, 1, 1);
        LocalDate end = LocalDate.of(2025, 10, 8);

        Period p = Period.between(start, end);
        System.out.printf("%d лет, %d месяцев, %d дней%n", p.getYears(), p.getMonths(), p.getDays());
        // 5 лет, 9 месяцев, 7 дней

        LocalTime t1 = LocalTime.of(10, 0);
        LocalTime t2 = LocalTime.of(12, 30);
        Duration d = Duration.between(t1, t2);
        System.out.println(d.toMinutes()); // 150 минут
    }
}
