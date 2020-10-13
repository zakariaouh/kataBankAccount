package treatment.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    private static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static String getDateAsString(LocalDate date) {
        return date.format(DD_MM_YYYY);
    }

    public LocalDate today() {
        return LocalDate.now();
    }


}
