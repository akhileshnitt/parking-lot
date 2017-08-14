package executor;


import model.Slot;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CreateParkingLotExecutor implements  CommandExecutor{

    private  Slot [] slots;

    @Override
    public void execute(String command) {
        //System.out.println("inside CreateParkingLotExecutor :"+command);

        String []commands = command.split(" ");
        Integer lotSize = Integer.parseInt(commands[1]);
        slots = new Slot[lotSize];
        for(int i=0;i<lotSize;i++){
            slots[i] = new Slot(i);
        }
        System.out.println("Created a parking lot with "+lotSize+ " slots");
    }


    public Slot[] getSlots() {
        return slots;
    }


}

