package executor;

import org.springframework.stereotype.Component;

@Component("park")
public class ParkExecutor<String> implements CommandExecutor<String> {
    @Override
    public void execute(String string) {

        System.out.println("Inside park ::"+string);
    }
}
