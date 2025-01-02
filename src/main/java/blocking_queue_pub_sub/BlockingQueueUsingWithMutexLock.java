package main.java.blocking_queue_pub_sub;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueUsingWithMutexLock<T> {
    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    Lock lock;

    public BlockingQueueUsingWithMutexLock(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.lock = new ReentrantLock();
    }

    public void enqueue(T item) throws InterruptedException {

        // wait for queue to have space
        lock.lock();
        while (size == capacity) {
           lock.unlock();
           lock.lock();
        }

        // reset tail to the beginning if the tail is already
        // at the end of the backing array
        if (tail == capacity) {
            tail = 0;
        }

        // place the item in the array
        array[tail] = item;
        size++;
        tail++;

        // don't forget to notify any other threads waiting on
        // a change in value of size. There might be consumers
        // waiting for the queue to have atleast one element
        lock.unlock();
    }

    public  T dequeue() throws InterruptedException {

        // wait for atleast one item to be enqueued
        lock.lock();
        while (size == 0) {
           lock.unlock();
           lock.lock();
        }

        // reset head to start of array if its past the array
        if (head == capacity) {
            head = 0;
        }

        // store the reference to the object being dequeued
        // and overwrite with null
        T item = array[head];
        array[head] = null;
        head++;
        size--;

        // don't forget to call notify, there might be another thread
        // blocked in the enqueue method.
        lock.unlock();

        return item;
    }
}
