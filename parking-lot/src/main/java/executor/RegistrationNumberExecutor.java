package executor;

import model.Car;
import model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("registration_numbers_for_cars_with_colour")
public class RegistrationNumberExecutor implements CommandExecutor {

    @Autowired
    private ParkingLotExecutor create_parking_lot;

    @Override
    public void execute(String command) {
        String color = command.split(" ")[1];
        Slot[] slots = create_parking_lot.getSlots();
        for(Slot slot:slots){
            Car car = slot.getCar();
            if(car != null && car.getColor().equals(color)){
                System.out.print(car.getRegistrationNumber()+",");
            }
        }
        System.out.println();
    }
}
