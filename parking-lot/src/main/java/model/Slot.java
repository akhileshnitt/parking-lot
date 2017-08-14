package model;

public class Slot {
    private boolean isOccupied;
    private Car car;
    private int slotId;

    public int getSlotId() {
        return slotId;
    }

    public Slot(int slotId) {
        this.slotId = slotId+1;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
