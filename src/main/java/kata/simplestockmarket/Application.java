package kata.simplestockmarket;

import kata.simplestockmarket.service.SimpleStockMarketService;
import kata.simplestockmarket.service.SimpleStockMarketServiceImpl;

public class Application {

    public static void main(String[] args) {
        final String stockSymbol = "POP";
        final String inputPrice = "1";

        final SimpleStockMarketService application = new SimpleStockMarketServiceImpl();
        SimpleStockMarketServiceImpl.Result result = application.queryStockInformation(stockSymbol, inputPrice);

        System.out.println("Dividend Yield: " + result.getDividendYield().getValue());
        System.out.println("Price/earnings ratio: " + result.getPriceEarningsRatio().getValue());
    }

}
