package task14;

import org.junit.jupiter.api.function.Executable;

public class Task implements Executable {
    private final Runnable runnable;

    public Task(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void execute() throws Throwable {
        runnable.run();
    }
}
