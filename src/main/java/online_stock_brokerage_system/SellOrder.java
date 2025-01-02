package main.java.online_stock_brokerage_system;

public class SellOrder extends Order {

    public SellOrder(String orderId, Account account, Stock stock, int quantity) {
        super(orderId, account, stock, quantity);
    }

    @Override
    public void execute() {
        double totalCost = stock.getPrice() * quantity;
        Integer currentQuantity = account.getPortfolio().getHoldings().get(stock.getSymbol());

        if (currentQuantity == null || currentQuantity <= 0) {
            status = OrderStatus.REJECTED;
            throw new InsufficientStockException("expected stocks are not present in the portfolio");
        }

        account.deposit(totalCost);
        account.getPortfolio().removeStock(stock, quantity);
        status = OrderStatus.EXECUTED;
    }
}
