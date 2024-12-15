package main.java.design_patterns.observer;

//Observer Pattern: an Object (Observable) maintains list of its dependents(Observers) and
// notifies them in any changes of state
public interface Observer {
    void sendCommunication();
}

class PN implements Observer{
   public void  sendCommunication() {
       System.out.println("sending pn");
   }
}

class SMS implements  Observer {
    public void  sendCommunication() {
        System.out.println("sending sms");
    }
}


