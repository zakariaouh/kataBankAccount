package treatment.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class AmountParser {
    private AmountParser() {
    }

    private static final DecimalFormat decimalFormatter = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));

    public static String pars(BigDecimal amount) {
        return decimalFormatter.format(amount);
    }
}
