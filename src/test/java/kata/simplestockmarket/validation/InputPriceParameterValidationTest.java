package kata.simplestockmarket.validation;

import kata.simplestockmarket.model.InputPrice;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputPriceParameterValidationTest {

    private InputPrice givenInput;
    private boolean result;

    @Test
    public void givenInputIsNegativeThenShouldReturnFalse() {
        givenInput(-1);

        whenCallingService();

        thenResultIsFalse();
    }

    @Test
    public void givenInputIsZeroThenShouldReturnTrue() {
        givenInput(0);

        whenCallingService();

        thenResultIsTrue();
    }

    @Test
    public void givenInputIsOneThenShouldReturnTrue() {
        givenInput(1);

        whenCallingService();

        thenResultIsTrue();
    }

    private void thenResultIsFalse() {
        assertFalse(result);
    }

    private void thenResultIsTrue() {
        assertTrue(result);
    }

    private void whenCallingService() {
        final InputPriceParameterValidation validation = new InputPriceParameterValidation();
        result = validation.isValid(givenInput);
    }

    private void givenInput(int input) {
        givenInput = InputPrice.of(new BigDecimal(input));
    }

}