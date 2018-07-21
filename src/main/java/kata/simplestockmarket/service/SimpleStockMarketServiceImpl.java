package kata.simplestockmarket.service;

import kata.simplestockmarket.dao.InMemoryStockDao;
import kata.simplestockmarket.dao.StockDao;
import kata.simplestockmarket.model.DividendYield;
import kata.simplestockmarket.model.InputPrice;
import kata.simplestockmarket.model.PriceEarningsRatio;
import kata.simplestockmarket.model.stock.Stock;
import kata.simplestockmarket.model.stock.StockSymbol;
import kata.simplestockmarket.service.dividend.DividendYieldCalculatorFactory;
import kata.simplestockmarket.service.dividend.DividendYieldCalculatorFactoryImpl;
import kata.simplestockmarket.service.priceearnings.PriceEarningsCalculator;
import kata.simplestockmarket.service.priceearnings.PriceEarningsCalculatorImpl;
import kata.simplestockmarket.validation.InputPriceParameterValidation;
import kata.simplestockmarket.validation.SimpleParameterValidation;
import kata.simplestockmarket.validation.StockSymbolParameterValidation;

import java.math.BigDecimal;

public class SimpleStockMarketServiceImpl implements SimpleStockMarketService {

    private final StockDao stockDao = new InMemoryStockDao();
    private final DividendYieldCalculatorFactory dividendYieldFactory = new DividendYieldCalculatorFactoryImpl();
    private final PriceEarningsCalculator priceEarningsCalculator = new PriceEarningsCalculatorImpl();
    private final SimpleParameterValidation stockSymbolValidation = new StockSymbolParameterValidation(stockDao);
    private final SimpleParameterValidation inputPriceValidation = new InputPriceParameterValidation();

    @Override
    public Result queryStockInformation(String stockSymbol, String inputPrice) {
        final StockSymbol symbol = StockSymbol.of(stockSymbol);
        final InputPrice price = InputPrice.of(new BigDecimal(inputPrice));

        validateParameters(symbol, price);

        final DividendYield dividend = calculateDividendYield(symbol, price);
        final PriceEarningsRatio priceEarnings = priceEarningsCalculator.calculate(dividend, price);

        final Result Result = new Result();
        Result.setDividendYield(dividend);
        Result.setPriceEarningsRatio(priceEarnings);
        return Result;
    }

    public DividendYield calculateDividendYield(StockSymbol symbol, InputPrice price) {
        final Stock stock = stockDao.getStock(symbol);
        return dividendYieldFactory.get(stock.getType()).calculate(stock, price);
    }

    private void validateParameters(StockSymbol symbol, InputPrice price) {
        if (!stockSymbolValidation.isValid(symbol)) {
            throw new IllegalArgumentException("Stock symbol '" + symbol + "' is not valid.");
        } else if (!inputPriceValidation.isValid(price)) {
            throw new IllegalArgumentException("Input price '" + price + "' is not valid.");
        }
    }

    public static final class Result {

        private DividendYield dividendYield;
        private PriceEarningsRatio priceEarningsRatio;

        public DividendYield getDividendYield() {
            return dividendYield;
        }

        public void setDividendYield(DividendYield dividendYield) {
            this.dividendYield = dividendYield;
        }

        public PriceEarningsRatio getPriceEarningsRatio() {
            return priceEarningsRatio;
        }

        public void setPriceEarningsRatio(PriceEarningsRatio priceEarningsRatio) {
            this.priceEarningsRatio = priceEarningsRatio;
        }
    }
}
