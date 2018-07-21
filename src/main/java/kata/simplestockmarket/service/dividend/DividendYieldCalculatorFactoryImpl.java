package kata.simplestockmarket.service.dividend;

import kata.simplestockmarket.model.stock.StockType;
import kata.simplestockmarket.service.StockTypeNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DividendYieldCalculatorFactoryImpl implements DividendYieldCalculatorFactory {

    private final Map<StockType, DividendYieldCalculator> mapping = new HashMap<>();

    public DividendYieldCalculatorFactoryImpl() {
        mapping.put(StockType.COMMON, new CommonDividendYieldCalculator());
        mapping.put(StockType.PREFERRED, new PreferredDividendYieldCalculator());
    }

    @Override
    public DividendYieldCalculator get(StockType stockType) {
        return Optional.ofNullable(mapping.get(stockType))
                       .orElseThrow(() -> new StockTypeNotFoundException(stockType));
    }
}
