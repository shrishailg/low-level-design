package main.java.noftify_me.observable;

import main.java.noftify_me.items.ItemStatus;
import main.java.noftify_me.observers.Observer;

public interface ItemStockObservable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifySubscribers();
    void setItemStockStatus(ItemStatus stockStatus);
}
