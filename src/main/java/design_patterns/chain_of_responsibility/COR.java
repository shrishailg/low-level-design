package main.java.design_patterns.chain_of_responsibility;

//chain of responsibility: Allows multiple objects to handle a request
// without the sender needing to know which object will ultimately process it

//client
public class COR {
    private static Logger doChaining(){
        Logger consoleLogger = new ConsoleBasedLogger();

        Logger errorLogger = new ErrorBasedLogger();
        consoleLogger.setNextLevelLogger(errorLogger);

        Logger debugLogger = new DebugBasedLogger();
        errorLogger.setNextLevelLogger(debugLogger);

        return consoleLogger;
    }

    public static void main(String[] args){
        Logger logger= doChaining();

        logger.logMessage("Enter the sequence of values ");
        logger.logMessage("An error is occured now");
        logger.logMessage("This was the error now debugging is compeled");
    }
}


abstract class Logger {

    protected Logger nextLevelLogger;

    public void setNextLevelLogger(Logger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(String msg){
        if (nextLevelLogger!=null) {
            nextLevelLogger.logMessage(msg);
        }
    }

}

class ConsoleBasedLogger extends Logger {
    public ConsoleBasedLogger() {
    }

    public void logMessage(String msg){
        if (nextLevelLogger!=null) {
            nextLevelLogger.logMessage(msg);
        } else {

        }
    }
}

class DebugBasedLogger extends Logger {
    public DebugBasedLogger() {
    }

}

class ErrorBasedLogger extends Logger {
    public ErrorBasedLogger() {
    }
}

