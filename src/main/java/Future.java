package main.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Future<L extends Number> {

    public static void main(String[] xyz) {
//        long number = 10;
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Long> futureTask = executorService.submit(() -> factorial(number));
//
//        while (!futureTask.isDone()) {
//            System.out.println("FutureTask is not finished yet...");
//        }
//        long result = futureTask.get();
//
//        threadpool.shutdown();
    }

    private static Long factorial(Long num) {
        return num;
    }
}
