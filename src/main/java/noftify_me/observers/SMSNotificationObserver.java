package main.java.noftify_me.observers;

import main.java.noftify_me.items.ItemStatus;
import main.java.noftify_me.observable.ItemStockObservableImpl;

public class SMSNotificationObserver implements  Observer{
    private final ItemStockObservableImpl itemStockObservable;

    public SMSNotificationObserver(ItemStockObservableImpl itemStockObservable) {
        this.itemStockObservable = itemStockObservable;
    }

    @Override
    public void sendNotification() {
        if (itemStockObservable.getItemStockStatus() == ItemStatus.AVAILABLE) {
            System.out.println("sending sms");
        }
    }
}
