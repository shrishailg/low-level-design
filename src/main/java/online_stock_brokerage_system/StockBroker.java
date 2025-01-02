package main.java.online_stock_brokerage_system;

import java.awt.event.WindowStateListener;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;

public class StockBroker {
    private static StockBroker instance;
    private Map<String, Account> accounts;
    private Map<String, Stock> stocks;
    private Queue<Order> orderQueue;
    private  AtomicInteger accountIdCounter;

    private StockBroker() {
        accounts = new ConcurrentHashMap<>();
        stocks = new ConcurrentHashMap<>();
        orderQueue = new ConcurrentLinkedQueue<>();
        accountIdCounter = new AtomicInteger(1);
    }

    public static synchronized StockBroker getInstance() {
        if (instance == null) {
            instance = new StockBroker();
        }

        return instance;
    }

    public void placeOrder(Order order) {
        orderQueue.offer(order);
        processOrders();
    }

    private void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            try {
                order.execute();
            } catch (InsufficientBalanceException | InsufficientStockException e) {
                // Handle exception and notify user
                System.out.println("Order failed: " + e.getMessage());
            }
        }
    }

    public void createAccount(User user, double initialBalance, Portfolio portfolio) {
        String accountId = generateAccountId();
        Account account = new Account(user, accountId, initialBalance, portfolio);
        accounts.put(accountId, account);
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    private String generateAccountId() {
        int accountId = accountIdCounter.getAndIncrement();
        return "A" + String.format("%03d", accountId);
    }
}
