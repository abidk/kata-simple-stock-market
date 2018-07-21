package kata.simplestockmarket.model.stock;

import java.math.BigDecimal;

public final class StockLastDividend {

    private final BigDecimal value;

    private StockLastDividend(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static StockLastDividend of(BigDecimal price) {
        return new StockLastDividend(price);
    }
}
