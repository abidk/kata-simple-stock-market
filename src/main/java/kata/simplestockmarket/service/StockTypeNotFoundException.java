package kata.simplestockmarket.service;

import kata.simplestockmarket.model.stock.StockType;

public class StockTypeNotFoundException extends RuntimeException {

    public StockTypeNotFoundException(StockType stockType) {
        super("Stock type '" + stockType + "' not found");
    }
}
