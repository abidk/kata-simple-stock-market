package kata.simplestockmarket.model;

import java.math.BigDecimal;

public final class InputPrice {

    private final BigDecimal value;

    public InputPrice(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public boolean isGreaterThanZero() {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isZero() {
        return value.compareTo(BigDecimal.ZERO) == 0;
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }

    public static InputPrice of(BigDecimal price) {
        return new InputPrice(price);
    }

}
