package kata.simplestockmarket.dao;

import kata.simplestockmarket.model.stock.CommonStock;
import kata.simplestockmarket.model.stock.PreferredStock;
import kata.simplestockmarket.model.stock.Stock;
import kata.simplestockmarket.model.stock.StockSymbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InMemoryStockDaoTest {

    private StockSymbol givenStockSymbol;
    private Stock result;

    @Test
    public void whenRequestingPopStockShouldReturnCorrectGinStock() {
        givenStockSymbol("POP");

        whenCallingService();

        thenStockIsCommonStock("POP", "8", "100");
    }

    @Test
    public void whenRequestingGinStockShouldReturnCorrectGinStock() {
        givenStockSymbol("GIN");

        whenCallingService();

        thenStockIsPreferredStock("GIN", "8", "0.02", "100");
    }

    private void thenStockIsCommonStock(String expectedSymbol, String expectedLastDividend, String expectedParValue) {
        assertEquals(CommonStock.class, result.getClass());

        final CommonStock stockResult = (CommonStock) result;
        assertEquals(expectedSymbol, stockResult.getSymbol().getValue());
        assertEquals(expectedLastDividend, stockResult.getLastDividend().getValue().toPlainString());
        assertEquals(expectedParValue, stockResult.getParValue().getValue().toPlainString());
    }

    private void thenStockIsPreferredStock(String expectedSymbol, String expectedLastDividend, String expectedFixedDividend, String expectedParValue) {
        assertEquals(PreferredStock.class, result.getClass());

        final PreferredStock stockResult = (PreferredStock) result;
        assertEquals(expectedSymbol, stockResult.getSymbol().getValue());
        assertEquals(expectedLastDividend, stockResult.getLastDividend().getValue().toPlainString());
        assertEquals(expectedFixedDividend, stockResult.getFixedDividend().getValue().toPlainString());
        assertEquals(expectedParValue, stockResult.getParValue().getValue().toPlainString());
    }

    private void whenCallingService() {
        final StockDao stockDao = new InMemoryStockDao();
        result = stockDao.getStock(givenStockSymbol);
    }

    private void givenStockSymbol(String symbol) {
        givenStockSymbol = StockSymbol.of(symbol);
    }
}