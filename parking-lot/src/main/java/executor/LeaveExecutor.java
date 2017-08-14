package executor;

import model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("leave")
public class LeaveExecutor implements CommandExecutor {

    @Autowired
    private CreateParkingLotExecutor create_parking_lot;

    @Override
    public void execute(String command) {
      //  System.out.println("inside leave execuor::"+command);
        String [] commands = command.split(" ");
        Integer freeSlot = Integer.parseInt(commands[1]);
        Slot slot = create_parking_lot.getSlots()[freeSlot-1];
        slot.setOccupied(false);
        slot.setCar(null);
        System.out.println("Slot number "+freeSlot+ " is free");
    }
}
