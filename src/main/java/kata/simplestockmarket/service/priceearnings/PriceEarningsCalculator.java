package kata.simplestockmarket.service.priceearnings;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.PriceEarningsRatio;

public interface PriceEarningsCalculator {

    PriceEarningsRatio calculate(DividendYield dividend, InputPrice price);

}
