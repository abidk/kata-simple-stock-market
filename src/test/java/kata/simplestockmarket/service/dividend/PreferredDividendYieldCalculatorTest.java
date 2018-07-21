package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.stock.PreferredStock;
import kata.simplestockmarket.service.dividend.PreferredDividendYieldCalculator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PreferredDividendYieldCalculatorTest {

    private static final PreferredStock GIN_STOCK = new PreferredStock.Builder().stockSymbol("GIN").lastDividend("8").fixedDividend("0.02").parValue("100").build();

    private InputPrice givenPrice;
    private PreferredStock givenStock;
    private DividendYield result;

    @Test
    public void givenStockAndInputPriceIsOneShouldReturnCorrectValue() {
        givenPriceInput(1);
        givenStock(GIN_STOCK);

        whenCallingService();

        thenResultIs("2.000");
    }

    @Test
    public void givenStockAndInputPriceIsTwoShouldReturnCorrectValue() {
        givenPriceInput(2);
        givenStock(GIN_STOCK);

        whenCallingService();

        thenResultIs("1.000");
    }

    @Test
    public void givenStockAndInputPriceIsTenShouldReturnCorrectValue() {
        givenPriceInput(10);
        givenStock(GIN_STOCK);

        whenCallingService();

        thenResultIs("0.200");
    }

    private void thenResultIs(String expectedValue) {
        assertEquals(expectedValue, result.getValue().toPlainString());
    }

    private void whenCallingService() {
        final PreferredDividendYieldCalculator calculator = new PreferredDividendYieldCalculator();
        result = calculator.calculate(givenStock, givenPrice);
    }

    private void givenStock(PreferredStock withStock) {
        givenStock = withStock;
    }

    private void givenPriceInput(int withPrice) {
        givenPrice = InputPrice.of(new BigDecimal(withPrice));
    }
}