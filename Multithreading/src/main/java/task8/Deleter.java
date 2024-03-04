package task8;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Deleter extends Thread{
    private final ArrayList<Integer> list;
    private final int count;
    private final ReentrantLock locker;
    private final Condition empty_condition;

    public Deleter(ArrayList<Integer> list, int count, ReentrantLock locker, Condition empty_condition){
        this.list = list;
        this.count = count;
        this.locker = locker;
        this.empty_condition = empty_condition;
    }

    @Override
    public void run(){
        for(int i = 0; i < count; i++) {
            locker.lock();
            try{
                while (list.isEmpty()) {
                    empty_condition.await();
                }
                Random random = new Random();
                int index = random.nextInt(list.size());
                list.remove(index);
                System.out.println("        я делитнул с позиции " + index);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                locker.unlock();
            }
        }
    }
}
