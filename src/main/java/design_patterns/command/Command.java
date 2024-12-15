package main.java.design_patterns.command;

//command pattern: This pattens helps in turning requests(commands) into objects
// allowing  either parameterized or queue them. This will help to decouple the request and sender
public class Command {
}

interface ICommand {
    void execute();
}

class TurnAcOnCommand implements ICommand {
    AirConditioner airConditioner;

    public TurnAcOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOnAc();;
    }
}

class TurnAcOffCommand implements ICommand {
    AirConditioner airConditioner;

    public TurnAcOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOffAc();;
    }
}


class AirConditioner {
    private boolean isOn;
    private int temperature;

    public AirConditioner() {
        this.isOn = false;
        this.temperature = 0;
    }

    public void turnOnAc() {
        isOn = true;
        System.out.println("turning on the ac");
    }

    public void turnOffAc() {
        isOn = true;
        System.out.println("turning off the ac");
    }

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("setting temperature");
    }
}