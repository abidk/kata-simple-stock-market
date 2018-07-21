package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.stock.StockType;

public interface DividendYieldCalculatorFactory {
    DividendYieldCalculator get(StockType stockType);
}
