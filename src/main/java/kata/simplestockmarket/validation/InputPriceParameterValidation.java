package kata.simplestockmarket.validation;

import kata.simplestockmarket.model.InputPrice;

public class InputPriceParameterValidation implements SimpleParameterValidation<InputPrice> {

    @Override
    public boolean isValid(InputPrice price) {
        return price.isZero() || price.isGreaterThanZero();
    }
}
