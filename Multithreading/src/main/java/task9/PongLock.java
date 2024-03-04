package task9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PongLock extends Thread {
    private final String string_pong = "        pong";
    private final Message message;
    private final ReentrantLock locker;
    private final Condition message_ping;
    private final Condition message_pong;

    public PongLock(Message message,ReentrantLock locker,Condition mping,Condition mpong){
        this.message = message;
        this.locker = locker;
        this.message_ping = mping;
        this.message_pong = mpong;
    }
    @Override
    public void run(){
        while(true) {
            locker.lock();
            try {
                while (message.getMessage().equals(string_pong)) {
                    try {
                        message_ping.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                message.setMessage(string_pong);
                message.printMessage();
                message_pong.signal();
            }finally {
                locker.unlock();
            }
        }
    }
}