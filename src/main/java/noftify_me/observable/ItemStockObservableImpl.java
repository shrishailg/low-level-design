package main.java.noftify_me.observable;

import main.java.noftify_me.items.ItemStatus;
import main.java.noftify_me.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class ItemStockObservableImpl implements ItemStockObservable {
    private final List<Observer> observerList;
    private ItemStatus currentItemStatus;

    public ItemStockObservableImpl() {
        this.observerList = new ArrayList<>();
        this.currentItemStatus = ItemStatus.DEFAULT;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(var observer: observerList) {
            observer.sendNotification();
        }
    }

    @Override
    public void setItemStockStatus(ItemStatus stockStatus) {
        currentItemStatus = stockStatus;
        if (stockStatus == ItemStatus.AVAILABLE) {
            notifySubscribers();
        }
    }

    public ItemStatus getItemStockStatus() {
        return currentItemStatus;
    }
}
