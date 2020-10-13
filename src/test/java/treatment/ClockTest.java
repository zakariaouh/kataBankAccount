package treatment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import treatment.tools.Clock;

import java.time.LocalDate;

class ClockTest {
    @Test
    void dateAsStringShouldReturnDateInDDMMYYYYFormat() {

        String date = Clock.getDateAsString(LocalDate.of(2000, 12, 20));
        Assertions.assertEquals("20/12/2000", date);
    }


}
