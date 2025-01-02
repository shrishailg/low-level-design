package main.java.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
    void ChangeState();
}

class ObservableImpl implements Observable {
    List<Observer> observers;

    public ObservableImpl() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (var observer: observers) {
            observer.sendCommunication();
        }
    }

    @Override
    public void ChangeState() {
        notifyObserver();
    }
}
