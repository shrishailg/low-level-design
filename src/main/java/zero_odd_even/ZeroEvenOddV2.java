package main.java.zero_odd_even;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOddV2 {
    private final int n;
    private int currentNumberToBePrinted;
    private int currentNumber;

    private final Lock lock = new ReentrantLock();
    private final Condition semZero = lock.newCondition();
    private final Condition semEven = lock.newCondition();
    private final Condition semOdd = lock.newCondition();

    public ZeroEvenOddV2(int n) {
        this.n = n;
        this.currentNumber = 1;
        this.currentNumberToBePrinted = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (currentNumber <= n) {
            while (currentNumberToBePrinted != 0) {
                semZero.await();
            }

            if (currentNumber <= n) {
                printNumber.accept(0);
            }
            currentNumberToBePrinted = currentNumber;

            if (currentNumber % 2 == 0) {
                semEven.signal();
            } else {
                semOdd.signal();
            }
        }
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (currentNumber <= n) {
            while (currentNumberToBePrinted == 0 || currentNumberToBePrinted % 2 != 0) {
                semEven.await();
            }

            if (currentNumberToBePrinted <= n) {
                printNumber.accept(currentNumberToBePrinted);
            }
            this.currentNumber += 1;
            currentNumberToBePrinted = 0;


            semZero.signal();
        }
        lock.unlock();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (currentNumber <= n) {
            while (currentNumberToBePrinted == 0 || currentNumberToBePrinted % 2 == 0) {
                semOdd.await();
            }


            if (currentNumberToBePrinted <= n) {
                printNumber.accept(currentNumberToBePrinted);
            }
            this.currentNumber += 1;
            currentNumberToBePrinted = 0;


            semZero.signal();
        }
        lock.unlock();
    }
}
