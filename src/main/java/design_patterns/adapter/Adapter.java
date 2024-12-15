package main.java.design_patterns.adapter;

//This pattern acts as a bridge or intermediate between 2 incompatible interfaces
public class Adapter {
    public static void main(String... args) {
        WeightMachine weightMachine = new WeightMachineImpl();

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(weightMachine);

        System.out.println(weightMachineAdapter.getWeightInKgs());
    }
}

interface WeightMachine {
    int getWeightInPound();
}

interface WeightMachineAdapter {
    double getWeightInKgs();
}

class WeightMachineImpl implements WeightMachine {
    public int getWeightInPound() {
        return 10;
    }
}

class WeightMachineAdapterImpl implements WeightMachineAdapter {
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    public double getWeightInKgs() {
        return weightMachine.getWeightInPound() * 0.45;
    }
}
