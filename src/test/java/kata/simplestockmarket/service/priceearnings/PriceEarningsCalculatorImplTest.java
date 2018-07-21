package kata.simplestockmarket.service.priceearnings;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.PriceEarningsRatio;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PriceEarningsCalculatorImplTest {

    private InputPrice givenPrice;
    private DividendYield givenDividend;
    private PriceEarningsRatio result;

    @Test
    public void givenInputPriceZeroAndDividendOneShouldCalculatePECorrectly() {
        givenDividend(1);
        givenPriceInput(0);

        whenCallingService();

        thenResultIs("0.000");
    }

    @Test
    public void givenInputPriceOneAndDividendOneShouldCalculatePECorrectly() {
        givenDividend(1);
        givenPriceInput(1);

        whenCallingService();

        thenResultIs("1.000");
    }

    @Test
    public void givenInputPriceTwoAndDividendOneShouldCalculatePECorrectly() {
        givenDividend(1);
        givenPriceInput(2);

        whenCallingService();

        thenResultIs("2.000");
    }

    @Test
    public void givenInputPriceTenAndDividendTwoShouldCalculatePECorrectly() {
        givenDividend(2);
        givenPriceInput(10);

        whenCallingService();

        thenResultIs("5.000");
    }

    private void thenResultIs(String expectedValue) {
        assertEquals(expectedValue, result.getValue().toPlainString());
    }

    private void whenCallingService() {
        final PriceEarningsCalculator calculator = new PriceEarningsCalculatorImpl();
        result = calculator.calculate(givenDividend, givenPrice);
    }

    private void givenDividend(int withDividend) {
        givenDividend = DividendYield.of(new BigDecimal(withDividend));
    }

    private void givenPriceInput(int withPrice) {
        givenPrice = InputPrice.of(new BigDecimal(withPrice));
    }

}
