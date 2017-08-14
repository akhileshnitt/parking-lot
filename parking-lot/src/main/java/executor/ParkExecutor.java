package executor;

import model.Car;
import model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("park")
public class ParkExecutor implements CommandExecutor {

    @Autowired
    private CreateParkingLotExecutor create_parking_lot;

    @Override
    public void execute(String command) {
       // System.out.println("inside ParkExecutor execuor::"+command+"   slot::"+create_parking_lot.getSlots().length);

        String []commands = command.split(" ");
        String registrationNumber = commands[1];
        String color = commands[2];

        Slot slot = findFreeAvailableSlot(create_parking_lot.getSlots());

        if(slot == null){
            System.out.println("Sorry, Parking lot is full");
        }
        else {
            Car car = new Car(registrationNumber,color);
            slot.setCar(car);
            slot.setOccupied(true);
            System.out.println("Allocated slot number: "+slot.getSlotId());
        }

    }

    private Slot findFreeAvailableSlot(Slot[] slots) {

        for(int i=0;i<slots.length;i++){
            if(!slots[i].isOccupied()){
                return slots[i];
            }
        }
        return null;
    }
}
