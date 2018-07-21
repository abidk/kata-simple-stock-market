package kata.simplestockmarket.service;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class SimpleStockMarketServiceImplTest {

    @Test
    public void whenValidSymbolAndInputShouldReturnCorrectResult() {
        // arrange
        final String stockSymbol = "POP";
        final String inputPrice = "20";

        // act
        SimpleStockMarketServiceImpl application = new SimpleStockMarketServiceImpl();
        SimpleStockMarketServiceImpl.Result result = application.queryStockInformation(stockSymbol, inputPrice);

        // assert
        assertEquals("0.400", result.getDividendYield().getValue().toPlainString());
        assertEquals("50.000", result.getPriceEarningsRatio().getValue().toPlainString());
    }

    @Test
    public void whenInvalidStockSymbolShouldThrowValidationError() {
        // arrange
        final String stockSymbol = "ABC";
        final String inputPrice = "1";

        // act
        SimpleStockMarketServiceImpl application = new SimpleStockMarketServiceImpl();

        // assert
        try {
            application.queryStockInformation(stockSymbol, inputPrice);
        } catch (IllegalArgumentException e) {
            assertEquals("Stock symbol 'ABC' is not valid.", e.getMessage());
            return;
        }

        fail("Expected an exception");
    }

    @Test
    public void whenInputPriceIsNegativedShouldThrowValidationError() {
        // arrange
        final String stockSymbol = "POP";
        final String inputPrice = "-1";

        // act
        SimpleStockMarketServiceImpl application = new SimpleStockMarketServiceImpl();

        // assert
        try {
            application.queryStockInformation(stockSymbol, inputPrice);
        } catch (IllegalArgumentException e) {
            assertEquals("Input price '-1' is not valid.", e.getMessage());
            return;
        }

        fail("Expected an exception");
    }

}
