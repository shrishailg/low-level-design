package main.java.design_patterns.state;

//State pattern: allows object to alter its behaviour when its internal state changes
public class State {
}


class Vendingmachine {
    VendingState vendingState;

    public VendingState getMachineState() {
        return  vendingState;
    }

    public void setMachineState(VendingState vendingState) {
        this.vendingState = vendingState;
    }
}

interface VendingState {
    void insertCoin(Vendingmachine product);
    void despenseItem(Vendingmachine product);
}

class IdleState implements  VendingState {
    public void insertCoin(Vendingmachine product) {
        System.out.println("Coin Inserted");
        product.setMachineState(new WorkingState());
    }

    public void despenseItem(Vendingmachine product){

    }
}

class WorkingState implements VendingState {
    public void insertCoin(Vendingmachine product) {
    }

    public void despenseItem(Vendingmachine product){

    }
}