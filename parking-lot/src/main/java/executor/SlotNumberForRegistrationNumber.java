package executor;

import model.Car;
import model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("slot_number_for_registration_number")
public class SlotNumberForRegistrationNumber implements CommandExecutor {

    @Autowired
    private ParkingLotExecutor create_parking_lot;

    @Override
    public void execute(String command) {
        String registrationNumber = command.split(" ")[1];
        boolean found = false;
        Slot[] slots = create_parking_lot.getSlots();
        for(Slot slot:slots){
            Car car = slot.getCar();
            if(car != null && car.getRegistrationNumber().equals(registrationNumber)){
                System.out.println(slot.getSlotId()+",");
                found = true;
            }
        }

        if(!found) {
            System.out.println("Not Found");
        }
    }


}
