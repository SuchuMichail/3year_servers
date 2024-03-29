package task12;

import java.util.concurrent.locks.ReentrantLock;

public class IntegerShell {
    private int position;
    private final ReentrantLock locker;

    public IntegerShell(int position){
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
