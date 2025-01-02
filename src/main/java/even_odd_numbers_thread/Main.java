package main.java.even_odd_numbers_thread;


public class Main {

    public static void main(String[] args) {
        State state = new State(PrinterType.ODD);
        Printer oddPrinter = new Printer(2, state, 1, PrinterType.ODD, PrinterType.EVEN, 10);
        Printer evenPrinter = new Printer(2, state, 2, PrinterType.EVEN, PrinterType.ODD, 10);

        Thread oddThread = new Thread(oddPrinter);
        Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();
    }
}
