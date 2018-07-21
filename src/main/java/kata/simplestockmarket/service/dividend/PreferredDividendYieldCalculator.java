package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.stock.PreferredStock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PreferredDividendYieldCalculator implements DividendYieldCalculator<PreferredStock> {

    @Override
    public DividendYield calculate(PreferredStock stock, InputPrice price) {
        return calculateYield(stock, price);
    }

    private DividendYield calculateYield(PreferredStock stock, InputPrice price) {
        final BigDecimal fixedDividend = stock.getFixedDividend().getValue();
        final BigDecimal parValue = stock.getParValue().getValue();

        final BigDecimal result = fixedDividend
                .multiply(parValue)
                .divide(price.getValue())
                .setScale(3, RoundingMode.HALF_UP);

        return DividendYield.of(result);
    }
}
