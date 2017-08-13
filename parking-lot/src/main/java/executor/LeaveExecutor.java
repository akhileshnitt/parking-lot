package executor;

import org.springframework.stereotype.Component;

@Component("leave")
public class LeaveExecutor<Integer> implements CommandExecutor<Integer> {
    @Override
    public void execute(Integer slotNumber) {
        System.out.println("inside leave execuor::"+slotNumber);
    }
}
