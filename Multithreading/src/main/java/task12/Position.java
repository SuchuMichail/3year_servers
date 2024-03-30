package task12;

import java.util.concurrent.locks.ReentrantLock;

public class Position {
    private int position;
    private final ReentrantLock locker;

    public Position(int position){
        this.position = position;
        locker = new ReentrantLock();
    }

    public int getPosition(){
        return position;
    }

    public ReentrantLock getLocker(){
        return locker;
    }

    public void setPosition(int position){
        this.position = position;
    }
}
