package kata.simplestockmarket.model.stock;

public abstract class Stock {

    private final StockSymbol symbol;
    private final StockType type;
    private final StockLastDividend lastDividend;
    private final StockParValue parValue;

    protected Stock(StockSymbol symbol,
                    StockType type,
                    StockLastDividend lastDividend,
                    StockParValue parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }

    public StockSymbol getSymbol() {
        return symbol;
    }

    public StockType getType() {
        return type;
    }

    public StockLastDividend getLastDividend() {
        return lastDividend;
    }

    public StockParValue getParValue() {
        return parValue;
    }

}
