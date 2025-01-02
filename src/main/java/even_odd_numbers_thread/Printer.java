package main.java.even_odd_numbers_thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
Given an integer N, task is to print n numbers using threads where
thread 1 should print even numbers and
thread 2 should print odd numbers
 */
public class Printer implements Runnable {
    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;

    public Printer(Integer step, State state, Integer startValue, PrinterType currentPrinterType,
                   PrinterType nextPrinterType, Integer maxValue) {

        this.state = state;
        this.step = step;
        this.currentValue = startValue;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxValue = maxValue;
    }


    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                while (!currentPrinterType.equals(state.getNextToPrint())) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(currentValue);
                currentValue += step;
                state.setNextToPrint(nextPrinterType);
                state.notifyAll();
            }
        }
    }
}
