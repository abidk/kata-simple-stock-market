package kata.simplestockmarket.model.stock;

import java.math.BigDecimal;

public final class StockParValue {

    private final BigDecimal value;

    private StockParValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static StockParValue of(BigDecimal price) {
        return new StockParValue(price);
    }
}
