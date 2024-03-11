package task9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task9 {
    private static final String first_string = "ping";
    private static final String second_string = "           pong";
    
    public static void main(String[] args){
        ReentrantLock locker = new ReentrantLock();
        Condition condition = locker.newCondition();

        Thread ping = new PingPongMessage(locker,condition,first_string);
        Thread pong = new PingPongMessage(locker,condition,second_string);
        
        ping.start();
        pong.start();
    }
}
