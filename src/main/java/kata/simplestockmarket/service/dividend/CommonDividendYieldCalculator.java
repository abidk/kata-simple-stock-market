package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.stock.CommonStock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonDividendYieldCalculator implements DividendYieldCalculator<CommonStock> {

    @Override
    public DividendYield calculate(CommonStock stock, InputPrice price) {
        return calculateYield(stock, price);
    }

    private DividendYield calculateYield(CommonStock stock, InputPrice price) {
        final BigDecimal lastDividend = stock.getLastDividend().getValue();

        final BigDecimal result = lastDividend
                .divide(price.getValue())
                .setScale(3, RoundingMode.HALF_UP);

        return DividendYield.of(result);
    }
}
