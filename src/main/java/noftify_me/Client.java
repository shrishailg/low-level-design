package main.java.noftify_me;

import main.java.noftify_me.items.Iphone;
import main.java.noftify_me.items.ItemStatus;
import main.java.noftify_me.observable.ItemStockObservableImpl;
import main.java.noftify_me.observers.EmailNotificationObserver;
import main.java.noftify_me.observers.Observer;
import main.java.noftify_me.observers.SMSNotificationObserver;

public class Client {

    public static void main(String... args) {
        Iphone iphone = new Iphone();

        ItemStockObservableImpl itemStockObservable = new ItemStockObservableImpl();
        Observer emailObserver = new EmailNotificationObserver(itemStockObservable);
        Observer smsObserver = new SMSNotificationObserver(itemStockObservable);

        itemStockObservable.addObserver(emailObserver);
        itemStockObservable.addObserver(smsObserver);


        iphone.setStatus(ItemStatus.AVAILABLE);
        itemStockObservable.setItemStockStatus(ItemStatus.AVAILABLE);

    }
}
