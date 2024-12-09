package main.java.noftifyme.observers;

import main.java.noftifyme.items.ItemStatus;
import main.java.noftifyme.observable.ItemStockObservableImpl;

public class EmailNotificationObserver implements Observer {
    private final ItemStockObservableImpl itemStockObservable;

    public EmailNotificationObserver(ItemStockObservableImpl itemStockObservable) {
        this.itemStockObservable = itemStockObservable;
    }

    @Override
    public void sendNotification() {
        if (itemStockObservable.getItemStockStatus() == ItemStatus.AVAILABLE) {
            System.out.println("sending email");
        }
    }
}
