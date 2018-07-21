package kata.simplestockmarket.service;

public interface SimpleStockMarketService {

    SimpleStockMarketServiceImpl.Result queryStockInformation(String stockSymbol, String inputPrice);
}
