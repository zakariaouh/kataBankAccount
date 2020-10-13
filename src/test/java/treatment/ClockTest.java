package treatment;

import org.junit.jupiter.api.Test;
import treatment.tools.Clock;

import java.time.LocalDate;

class ClockTest {
    @Test
    void currentDateShouldReturnDateInDDMMYYYYFormat() {
      /*  Clock clock = new TestClock();
        String date = clock.currentDayAsString();
        Assertions.assertEquals("20/12/2000", date);*/
    }

    private class TestClock extends Clock {


        @Override
        public LocalDate today() {
            return LocalDate.of(2000, 12, 20);
        }
    }
}
