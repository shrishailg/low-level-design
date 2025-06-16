package main.java.onlinestockbrokeragesystem;

public class BuyOrder extends Order{

    public BuyOrder(String orderId, Account account, Stock stock, int quantity) {
        super(orderId, account, stock, quantity);
    }

    @Override
    public void execute() {
        double totalCost = stock.getPrice() * quantity;

        if (account.getBalance() >= totalCost) {
            account.withdraw(totalCost);

            //update portfolio
            account.getPortfolio().addStock(stock, quantity);

            status = OrderStatus.EXECUTED;
        } else {
            status = OrderStatus.REJECTED;
            throw new InsufficientBalanceException("Insufficient balance.");
        }
    }
}
