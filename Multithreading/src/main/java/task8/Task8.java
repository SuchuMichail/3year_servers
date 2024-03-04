package task8;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task8 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ReentrantLock locker = new ReentrantLock();
        Condition empty_condition = locker.newCondition();

        Thread first = new Adder(arrayList, 10_000, locker, empty_condition);
        Thread second = new Deleter(arrayList, 10_000, locker, empty_condition);

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println("Запустили два потока на базе двух разных классов\n" +
                "Они поработали с листом. И теперь лист имеет размер = " + arrayList.size() + "\n");
    }
}
