package kata.simplestockmarket.validation;

import kata.simplestockmarket.dao.InMemoryStockDao;
import kata.simplestockmarket.model.stock.StockSymbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockSymbolParameterValidationTest {

    private StockSymbol givenStockSymbol;
    private boolean result;

    @Test
    public void whenStockSymbolIsValidShouldReturnTrue() {
        givenStockSymbol("POP");

        whenCallingService();

        thenResultIs(true);
    }

    @Test
    public void whenStockSymbolIsNotValidShouldReturnFalse() {
        givenStockSymbol("ABC");

        whenCallingService();

        thenResultIs(false);
    }

    private void thenResultIs(boolean expectedResult) {
        assertEquals(expectedResult, result);
    }

    private void whenCallingService() {
        final StockSymbolParameterValidation validation = new StockSymbolParameterValidation(new InMemoryStockDao());
        result = validation.isValid(givenStockSymbol);
    }

    private void givenStockSymbol(String symbol) {
        givenStockSymbol = StockSymbol.of(symbol);
    }
}