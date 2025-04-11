import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExploration {
    public static void main(String[] args) {
        System.out.println("Scenario 1: Is Local Date Time Immutable ");
        isLocalDateTimeImmutable();
        System.out.println("-------------------------------------------");
        System.out.println("Scenario 2: Date and Time Handling(Precision)");
        dateAndTimeHandling();
        System.out.println("-------------------------------------------");
        System.out.println("Scenario 3: Standard Formatting and Parsing.");
        formattingAndParsing();
        System.out.println("-------------------------------------------");
        System.out.println("Scenario 4: Arithmetic Operation.");
        arithmeticOperation();
        System.out.println("-------------------------------------------");
        System.out.println("Scenario 5: Comparison.");
        comparison();
        System.out.println("-------------------------------------------");
        System.out.println("Scenario 6: Integration with other classes.");
        integration();
        System.out.println("-------------------------------------------");
        System.out.println("Scenario 7: Zone conversion.");
        zoneConversion();
        System.out.println("-------------------------------------------");
    }

    private static void integration() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 8, 5, 10, 30);
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("Local Date Time: " + localDateTime);
        System.out.println("Local Date: " + localDate);
        System.out.println("Local Time: " + localTime);
    }

    private static void zoneConversion() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 8, 5, 10, 30);
        ZonedDateTime calcuttaZone = localDateTime.atZone(ZoneId.of("Asia/Calcutta"));
        System.out.println("Zone date time: " + calcuttaZone);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/New_York"));
        System.out.println("Zoned date times: " + zonedDateTime); // Output: 2024-08-05T10:30-04:00[America/New_York]

    }

    private static void comparison() {
        LocalDateTime dateTime1 = LocalDateTime.of(2024, 8, 5, 10, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(2024, 8, 6, 10, 30);

        System.out.println(dateTime1.isBefore(dateTime2)); // Output: true
        System.out.println(dateTime1.isAfter(dateTime2));  // Output: false

    }

    private static void arithmeticOperation() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 8, 5, 16, 30, 24, 299999999);
        LocalDateTime updatedYear = localDateTime.plusYears(1);
        LocalDateTime updatedMonth = localDateTime.plusMonths(2);
        LocalDateTime updatedDays = localDateTime.plusDays(3);
        LocalDateTime updatedHours = localDateTime.plusHours(4);
        LocalDateTime updatedMinutes = localDateTime.plusMinutes(5);
        LocalDateTime updatedSeconds = localDateTime.plusSeconds(6);
        LocalDateTime updatedNanos = localDateTime.plusNanos(99999999);
        System.out.println("Actual: " + localDateTime);
        System.out.println("Updated year: " + updatedYear);
        System.out.println("Updated months: " + updatedMonth);
        System.out.println("Updated days: " + updatedDays);
        System.out.println("Updated hours: " + updatedHours);
        System.out.println("Updated min: " + updatedMinutes);
        System.out.println("Updated sec: " + updatedSeconds);
        System.out.println("Updated nano: " + updatedNanos);

        /*
         1. Likewise, Subtraction works. - minusYear and so on.
         2. Also, it can be combined into a single expression.
            LocalDateTime futureDateTime = dateTime.plusDays(10).plusHours(5); // Adds 10 days and 5 hours
        */
    }

    private static void formattingAndParsing() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-DD-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.of(1995, 05, 18, 18, 30);
        String formatted = dtf.format(localDateTime);
        System.out.println("Original Date Time: " + localDateTime);
        System.out.println("Formatted Date Time: " + formatted);
    }

    private static void dateAndTimeHandling() {
        LocalDateTime dateTime1 = LocalDateTime.of(2024, 8, 5, 10, 30, 15, 123456789);
        System.out.println(dateTime1); // Output: 2024-08-05T10:30:15.123456789
        LocalDateTime dateTime2 = LocalDateTime.of(2024, 8, 5, 10, 30, 15);
        System.out.println(dateTime2);
        LocalDateTime dateTime3 = LocalDateTime.of(2024, 8, 5, 10, 30);
        System.out.println(dateTime3);
        LocalDateTime dateTime4 = LocalDateTime.now();
        System.out.println(dateTime4);

    }

    private static void isLocalDateTimeImmutable() {
        LocalDateTime originalDateTime = LocalDateTime.of(2024, 8, 5, 10, 30);
        LocalDateTime updatedTime = originalDateTime.plusDays(1);
        System.out.println("Original: " + originalDateTime);
        System.out.println("Updated: " + updatedTime);
        System.out.println("Is original updated(cross/check): " + originalDateTime);
    }
}
