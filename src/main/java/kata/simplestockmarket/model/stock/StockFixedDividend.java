package kata.simplestockmarket.model.stock;

import java.math.BigDecimal;

public final class StockFixedDividend {

    private final BigDecimal value;

    private StockFixedDividend(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static StockFixedDividend of(BigDecimal price) {
        return new StockFixedDividend(price);
    }
}
