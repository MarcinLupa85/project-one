package date;

import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

public class DateFormatter {

    private static DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String getFormattedNowDate() {
        return timeStampPattern.format(now());
    }
}
