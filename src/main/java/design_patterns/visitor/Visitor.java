package main.java.design_patterns.visitor;

// this patten allows adding new operations to existing classes without modifying them
// and encourage open/closed principle
public class Visitor {
}

interface RoomElement {
    void accept(RoomVisitor roomVisitor);
}

class SingleRoom implements RoomElement {

    public int roomPrice = 10;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}

class DoubleRoom implements RoomElement {

    public int roomPrice = 110;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}

interface RoomVisitor {
    void visit(SingleRoom singleRoom);
    void visit(DoubleRoom doubleRoom);
}

class RoomPricingVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Setting the prices for single room");
        singleRoom.roomPrice = 1000;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Setting the prices for double room");
        doubleRoom.roomPrice = 1000;
    }
}

class RoomMaintenanceVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("perform maintenance for single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("perform maintenance for double room");
    }
}
