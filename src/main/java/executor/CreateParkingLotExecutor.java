package executor;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class CreateParkingLotExecutor<Integer> implements CommandExecutor<Integer> {
    @Override
    public void execute(Integer lotSize) {
        System.out.println("inside CreateParkingLotExecutor : "+lotSize);
    }
}
