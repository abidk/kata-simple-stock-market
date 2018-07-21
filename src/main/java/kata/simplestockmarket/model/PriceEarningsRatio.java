package kata.simplestockmarket.model;

import java.math.BigDecimal;

public class PriceEarningsRatio {

    private final BigDecimal value;

    private PriceEarningsRatio(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static PriceEarningsRatio of(BigDecimal price) {
        return new PriceEarningsRatio(price);
    }
}
