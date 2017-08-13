package executor;

public interface CommandExecutor<T> {

    public void execute(T t);
}
