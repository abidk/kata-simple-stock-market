package kata.simplestockmarket.model.stock;

import java.math.BigDecimal;

public final class CommonStock extends Stock {

    private CommonStock(StockSymbol stockSymbol,
                        StockLastDividend lastDividend,
                        StockParValue parValue) {
        super(stockSymbol, StockType.COMMON, lastDividend, parValue);
    }

    public static final class Builder {

        private StockSymbol symbol;
        private StockLastDividend lastDividend;
        private StockParValue parValue;

        public Builder stockSymbol(String symbolValue) {
            symbol = StockSymbol.of(symbolValue);
            return this;
        }

        public Builder lastDividend(String lastDividendValue) {
            lastDividend = StockLastDividend.of(new BigDecimal(lastDividendValue));
            return this;
        }

        public Builder parValue(String parValueValue) {
            parValue = StockParValue.of(new BigDecimal(parValueValue));
            return this;
        }

        public CommonStock build() {
            return new CommonStock(symbol, lastDividend, parValue);
        }
    }
}
