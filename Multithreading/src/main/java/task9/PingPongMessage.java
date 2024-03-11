package task9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongMessage extends Thread {
    private static String current_message_on_console = "           pong";
    private final ReentrantLock locker;
    private final Condition condition;
    private final String message;

    public PingPongMessage(ReentrantLock locker, Condition condition, String message){
        this.locker = locker;
        this.condition = condition;
        this.message = message;
    }

    @Override
    public void run(){
        while(true) {
            locker.lock();
            try {
                while (current_message_on_console.equals(message)) {
                    condition.await();
                }

                System.out.println(message);
                current_message_on_console = message;
                condition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                locker.unlock();
            }
        }
    }
}