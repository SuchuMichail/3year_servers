package task9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task9 {
    public static void main(String[] args){
        ReentrantLock locker = new ReentrantLock();
        Condition message_ping = locker.newCondition();
        Condition message_pong = locker.newCondition();

        Message message = new Message("");
        Thread ping = new PingLock(message,locker,message_ping,message_pong);
        Thread pong = new PongLock(message,locker,message_ping,message_pong);
        
        ping.start();
        pong.start();
    }
}
