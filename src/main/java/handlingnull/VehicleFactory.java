package main.java.handlingnull;

public class VehicleFactory {

   public Vehicle getVehicleObject(String type) {
       if ("Car".equals(type)) {
           return new Car();
       }

       return new DefaultVehicle();
   }
}
