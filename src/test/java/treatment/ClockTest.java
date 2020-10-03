package treatment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ClockTest {
    @Test
    void currentDateShouldReturnDateInDDMMYYYYFormat() {
        Clock clock = new TestClock();
        String date = clock.currentDayAsString();
        Assertions.assertEquals("20/12/2000", date);
    }

    private class TestClock extends Clock {


        @Override
        protected LocalDate today() {
            return LocalDate.of(2000, 12, 20);
        }
    }
}
