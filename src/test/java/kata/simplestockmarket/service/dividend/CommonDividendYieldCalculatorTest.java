package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.stock.CommonStock;
import kata.simplestockmarket.service.dividend.CommonDividendYieldCalculator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CommonDividendYieldCalculatorTest {

    private static final CommonStock POP_STOCK = new CommonStock.Builder().stockSymbol("POP").lastDividend("8").parValue("100").build();
    private static final CommonStock ALE_STOCK = new CommonStock.Builder().stockSymbol("ALE").lastDividend("23").parValue("60").build();
    private static final CommonStock TEA_STOCK = new CommonStock.Builder().stockSymbol("TEA").lastDividend("0").parValue("100").build();

    private InputPrice givenPrice;
    private CommonStock givenStock;
    private DividendYield result;

    @Test
    public void givenPopStockAndInputPriceIsOneShouldReturnCorrectValue() {
        givenPriceInput(1);
        givenStock(POP_STOCK);

        whenCallingService();

        thenResultIs("8.000");
    }

    @Test
    public void givenPopStockAndInputPriceIsTwoShouldReturnCorrectValue() {
        givenPriceInput(2);
        givenStock(POP_STOCK);

        whenCallingService();

        thenResultIs("4.000");
    }

    @Test
    public void givenAleStockAndInputPriceIsOneShouldReturnCorrectValue() {
        givenPriceInput(1);
        givenStock(ALE_STOCK);

        whenCallingService();

        thenResultIs("23.000");
    }

    @Test
    public void givenAleStockAndInputPriceIsTwoShouldReturnCorrectValue() {
        givenPriceInput(2);
        givenStock(ALE_STOCK);

        whenCallingService();

        thenResultIs("11.500");
    }

    @Test
    public void givenTeaStockAndInputPriceIsOneShouldReturnCorrectValue() {
        givenPriceInput(1);
        givenStock(TEA_STOCK);

        whenCallingService();

        thenResultIs("0.000");
    }

    @Test
    public void givenTeaStockAndInputPriceIsTwoShouldReturnCorrectValue() {
        givenPriceInput(2);
        givenStock(TEA_STOCK);

        whenCallingService();

        thenResultIs("0.000");
    }

    private void thenResultIs(String expectedValue) {
        assertEquals(expectedValue, result.getValue().toPlainString());
    }

    private void whenCallingService() {
        final CommonDividendYieldCalculator calculator = new CommonDividendYieldCalculator();
        result = calculator.calculate(givenStock, givenPrice);
    }

    private void givenStock(CommonStock withStock) {
        givenStock = withStock;
    }

    private void givenPriceInput(int withPrice) {
        givenPrice = InputPrice.of(new BigDecimal(withPrice));
    }
}
