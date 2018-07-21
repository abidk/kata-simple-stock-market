package kata.simplestockmarket.service.priceearnings;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.PriceEarningsRatio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceEarningsCalculatorImpl implements PriceEarningsCalculator {

    @Override
    public PriceEarningsRatio calculate(DividendYield dividend, InputPrice price) {
        return calculatePriceEarnings(dividend, price);
    }

    private PriceEarningsRatio calculatePriceEarnings(DividendYield dividend, InputPrice price) {
        final BigDecimal result = price.getValue()
                .divide(dividend.getValue())
                .setScale(3, RoundingMode.HALF_UP);

        return PriceEarningsRatio.of(result);
    }
}
