package main.java.online_stock_brokerage_system;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private final Map<String, Integer> holdings;

    public Portfolio() {
        this.holdings = new HashMap<>();
    }

    public synchronized void addStock(Stock stock, int quantity) {
        holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0)+quantity);
    }

    public synchronized void removeStock(Stock stock, int quantity) {
        String symbol = stock.getSymbol();

        if (!holdings.containsKey(symbol)) {
            throw new InsufficientStockException("Stock not found int eh portfolio.");
        }

        if (holdings.get(symbol) < quantity) {
            throw new InsufficientStockException("Insufficient stock quantity in the portfolio.");
        }

        holdings.put(symbol, holdings.get(symbol)-quantity);

        if (holdings.get(symbol) == 0) {
            holdings.remove(symbol);
        }
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }
}
