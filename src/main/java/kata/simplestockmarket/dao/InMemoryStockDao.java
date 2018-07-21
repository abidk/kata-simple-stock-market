package kata.simplestockmarket.dao;

import kata.simplestockmarket.model.stock.CommonStock;
import kata.simplestockmarket.model.stock.PreferredStock;
import kata.simplestockmarket.model.stock.Stock;
import kata.simplestockmarket.model.stock.StockSymbol;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStockDao implements StockDao {

    private static final String TEA_STOCK_NAME = "TEA";
    private static final String POP_STOCK_NAME = "POP";
    private static final String ALE_STOCK_NAME = "ALE";
    private static final String JOE_STOCK_NAME = "JOE";
    private static final String GIN_STOCK_NAME = "GIN";

    private final Map<String, Stock> stockData = new HashMap<>();

    public InMemoryStockDao() {
        stockData.put(TEA_STOCK_NAME, buildCommonStock(TEA_STOCK_NAME, "0", "100"));
        stockData.put(POP_STOCK_NAME, buildCommonStock(POP_STOCK_NAME, "8", "100"));
        stockData.put(ALE_STOCK_NAME, buildCommonStock(ALE_STOCK_NAME, "23", "60"));
        stockData.put(JOE_STOCK_NAME, buildCommonStock(JOE_STOCK_NAME, "13", "250"));
        stockData.put(GIN_STOCK_NAME, buildPreferredStock(GIN_STOCK_NAME, "8", "0.02", "100"));
    }

    @Override
    public Stock getStock(StockSymbol symbol) {
        // Convert request data into the business model using converter/row mapper etc.
        return stockData.get(symbol.getValue());
    }

    private CommonStock buildCommonStock(String symbol, String lastDividend, String parValue) {
        return new CommonStock.Builder()
                .stockSymbol(symbol)
                .lastDividend(lastDividend)
                .parValue(parValue)
                .build();
    }

    private PreferredStock buildPreferredStock(String symbol, String lastDividend, String fixedDividend, String parValue) {
        return new PreferredStock.Builder()
                .stockSymbol(symbol)
                .lastDividend(lastDividend)
                .fixedDividend(fixedDividend)
                .parValue(parValue)
                .build();
    }
}
