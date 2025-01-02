package main.java.online_stock_brokerage_system;

public abstract class Order {
    protected String orderId;
    protected Stock stock;
    protected Account account;
    protected int quantity;
    protected OrderStatus status;

    public Order(String orderId, Account account, Stock stock, int quantity) {
        this.orderId = orderId;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.status = OrderStatus.PENDING;
    }

    public abstract void execute();
}
