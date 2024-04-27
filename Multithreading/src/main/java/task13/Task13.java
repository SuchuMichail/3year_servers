package task13;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task13 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter count of writers");
        int countOfWriters = sc.nextInt();
        System.out.println("enter count of readers");
        int countOfReaders = sc.nextInt();

        DataQueue dataQueue = new DataQueue();
        ReentrantLock locker = new ReentrantLock();
        Condition condition = locker.newCondition();
        ExecutorService writersPool = Executors.newFixedThreadPool(countOfWriters);
        ExecutorService readersPool = Executors.newFixedThreadPool(countOfReaders);

        Thread writersPoolFill = new Thread(() -> {
            for (int i = 0; i < countOfWriters; i++) {
                int finalI = i;
                writersPool.execute(() -> {
                    locker.lock();
                    try {
                        dataQueue.addData(new Data(new int[]{finalI}));
                        System.out.println("Added " + finalI);
                        condition.signal();
                    } finally {
                        locker.unlock();
                    }
                });
            }
        });

        Thread readersPoolFill = new Thread(() -> {
            for (int i = 0; i < countOfReaders; i++) {
                readersPool.execute(() -> {
                    locker.lock();
                    try{
                        while(dataQueue.isEmpty()){
                            //condition.await();
                            if(!condition.await(100L, TimeUnit.MILLISECONDS)){
                                return;
                            }
                        }
                        System.out.println("Removed " + dataQueue.getData());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        locker.unlock();
                    }
                });
            }
        });

        readersPoolFill.start();
        writersPoolFill.start();
        readersPoolFill.join();
        writersPoolFill.join();

        writersPool.shutdown();
        readersPool.shutdown();
    }
}
