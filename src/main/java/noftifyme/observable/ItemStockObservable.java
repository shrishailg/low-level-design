package main.java.noftifyme.observable;

import main.java.noftifyme.items.ItemStatus;
import main.java.noftifyme.observers.Observer;

public interface ItemStockObservable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifySubscribers();
    void setItemStockStatus(ItemStatus stockStatus);
}
