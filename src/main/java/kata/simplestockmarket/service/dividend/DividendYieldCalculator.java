package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;

public interface DividendYieldCalculator<T> {
    DividendYield calculate(T stock, InputPrice price);
}
