package kata.simplestockmarket.model.stock;

import java.math.BigDecimal;

public final class PreferredStock extends Stock {

    private final StockFixedDividend fixedDividend;

    private PreferredStock(StockSymbol stockSymbol,
                           StockLastDividend lastDividend,
                           StockFixedDividend fixedDividend,
                           StockParValue parValue) {
        super(stockSymbol, StockType.PREFERRED, lastDividend, parValue);
        this.fixedDividend = fixedDividend;
    }

    public StockFixedDividend getFixedDividend() {
        return fixedDividend;
    }

    public static final class Builder {

        private StockSymbol symbol;
        private StockLastDividend lastDividend;
        private StockParValue parValue;
        private StockFixedDividend fixedDividend;

        public Builder stockSymbol(String symbolValue) {
            symbol = StockSymbol.of(symbolValue);
            return this;
        }

        public Builder lastDividend(String lastDividendValue) {
            lastDividend = StockLastDividend.of(new BigDecimal(lastDividendValue));
            return this;
        }

        public Builder fixedDividend(String fixedDividendValue) {
            fixedDividend = StockFixedDividend.of(new BigDecimal(fixedDividendValue));
            return this;
        }

        public Builder parValue(String parValueValue) {
            parValue = StockParValue.of(new BigDecimal(parValueValue));
            return this;
        }

        public PreferredStock build() {
            return new PreferredStock(symbol, lastDividend, fixedDividend, parValue);
        }
    }
}
