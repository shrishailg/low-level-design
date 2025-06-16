package main.java.evenoddnumbersthread;


public class State {
    private PrinterType nextToPrint;

    public State(PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;
    }

    public void setNextToPrint(PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;
    }

    public PrinterType getNextToPrint() {
        return this.nextToPrint;
    }
}
