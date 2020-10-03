package treatment;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;

public class ClockTest {
    @Test
    public void currentDateShouldReturnDateInDDMMYYYYFormat() {
        Clock clock = new TestClock();
        String date = clock.currentDayAsString();
        Assert.assertThat(date, is("20/12/2000"));
    }

    private class TestClock extends Clock {


        @Override
        protected LocalDate today() {
            return LocalDate.of(2000, 12, 20);
        }
    }
}
