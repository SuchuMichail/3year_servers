package task8;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Adder extends Thread{
    private final ArrayList<Integer> list;
    private final int count;
    private final ReentrantLock locker;
    private final Condition empty_condition;

    public Adder(ArrayList<Integer> list, int count, ReentrantLock locker, Condition empty_condition){
        this.list = list;
        this.count = count;
        this.locker = locker;
        this.empty_condition = empty_condition;
    }

    @Override
    public void run(){
        for(int i = 0; i < count; i++) {
            locker.lock();
            try {
                Random random = new Random();
                int x = random.nextInt();
                list.add(x);
                System.out.println("***** " + i + ") " + x);
                empty_condition.signal();
            }finally {
                locker.unlock();
            }
        }
    }
}
