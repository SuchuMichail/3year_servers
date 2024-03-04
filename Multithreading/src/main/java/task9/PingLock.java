package task9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingLock extends Thread {
    private final String string_ping = "ping";
    private final Message message;
    private final ReentrantLock locker;
    private final Condition message_ping;
    private final Condition message_pong;

    public PingLock(Message message,ReentrantLock locker,Condition mping,Condition mpong){
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
                while (message.getMessage().equals(string_ping)) {
                    try {
                        message_pong.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                message.setMessage(string_ping);
                message.printMessage();
                message_ping.signal();
            }finally {
                locker.unlock();
            }
        }
    }
}