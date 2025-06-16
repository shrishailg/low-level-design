package main.java.noftifyme;

import main.java.noftifyme.items.Iphone;
import main.java.noftifyme.items.ItemStatus;
import main.java.noftifyme.observable.ItemStockObservableImpl;
import main.java.noftifyme.observers.EmailNotificationObserver;
import main.java.noftifyme.observers.Observer;
import main.java.noftifyme.observers.SMSNotificationObserver;

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
