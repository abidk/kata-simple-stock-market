package kata.simplestockmarket.validation;

import kata.simplestockmarket.dao.StockDao;
import kata.simplestockmarket.model.stock.StockSymbol;

import java.util.Optional;

public class StockSymbolParameterValidation implements SimpleParameterValidation<StockSymbol> {

    private final StockDao stockDao;

    public StockSymbolParameterValidation(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public boolean isValid(StockSymbol symbol) {
        return symbolExists(symbol);
    }

    private boolean symbolExists(StockSymbol symbol) {
        return Optional.ofNullable(stockDao.getStock(symbol)).isPresent();
    }
}
