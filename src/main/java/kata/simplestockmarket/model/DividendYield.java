package kata.simplestockmarket.model;

import java.math.BigDecimal;

public class DividendYield {

    private final BigDecimal value;

    private DividendYield(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static DividendYield of(BigDecimal price) {
        return new DividendYield(price);
    }

}
