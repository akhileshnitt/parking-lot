package executor;

import model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("status")
public class StatusExecutor implements CommandExecutor {

    @Autowired
    private ParkingLotExecutor create_parking_lot;

    @Override
    public void execute(String command) {
        Slot []slots = create_parking_lot.getSlots();
        System.out.println("Slot No.    "+"     Registration No   "+ "   Colour");
        for(int i=0;i<slots.length;i++){
            Slot slot = slots[i];
            if(slot.isOccupied()){
                System.out.println(slot.getSlotId()+"                "+slot.getCar().getRegistrationNumber()+"        "+slot.getCar().getColor());
            }
        }
    }
}
