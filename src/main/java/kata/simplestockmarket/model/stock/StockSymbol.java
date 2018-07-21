package kata.simplestockmarket.model.stock;

public final class StockSymbol {

    private final String value;

    private StockSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static StockSymbol of(String value) {
        return new StockSymbol(value);
    }
}
