package executor;

import org.springframework.stereotype.Component;

@Component("status")
public class StatusExecutor<Void> implements CommandExecutor<Void> {
    @Override
    public void execute(Void aVoid) {
        System.out.println("Inside status");
    }
}
