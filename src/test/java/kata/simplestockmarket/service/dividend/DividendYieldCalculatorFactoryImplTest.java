package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.stock.StockType;
import kata.simplestockmarket.service.StockTypeNotFoundException;
import org.junit.Test;

import static kata.simplestockmarket.model.stock.StockType.COMMON;
import static kata.simplestockmarket.model.stock.StockType.PREFERRED;
import static org.junit.Assert.assertEquals;

public class DividendYieldCalculatorFactoryImplTest {

    private StockType givenStockType;
    private DividendYieldCalculator result;

    @Test
    public void givenCommonStockShouldReturnCommonCalculator() {
        givenStockType(COMMON);

        whenCallingService();

        thenResultIs(CommonDividendYieldCalculator.class);
    }

    @Test
    public void givenPreferredStockShouldReturnCommonCalculator() {
        givenStockType(PREFERRED);

        whenCallingService();

        thenResultIs(PreferredDividendYieldCalculator.class);
    }

    @Test(expected = StockTypeNotFoundException.class)
    public void givenUnknownStockTypeShouldThrowError() {
        givenStockType(null);

        whenCallingService();
    }

    private void thenResultIs(Class expectedClass) {
        assertEquals(expectedClass, result.getClass());
    }

    private void whenCallingService() {
        final DividendYieldCalculatorFactory factory = new DividendYieldCalculatorFactoryImpl();
        result = factory.get(givenStockType);
    }

    private void givenStockType(StockType withType) {
        givenStockType = withType;
    }

}