package kata.simplestockmarket.dao;

import kata.simplestockmarket.model.stock.Stock;
import kata.simplestockmarket.model.stock.StockSymbol;

public interface StockDao {

    Stock getStock(StockSymbol symbol);

}
