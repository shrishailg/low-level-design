package main.java.noftifyme.items;

public class Iphone extends Item {
    ItemStatus status;

    public Iphone() {
        this.status = ItemStatus.DEFAULT;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
