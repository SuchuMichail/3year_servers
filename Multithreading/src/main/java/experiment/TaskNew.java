package experiment;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int writersNum = sc.nextInt();
        int readersNum = sc.nextInt();
        ExecutorService writersPool = Executors.newFixedThreadPool(writersNum);
        ExecutorService readersPool = Executors.newFixedThreadPool(readersNum);
        DataQueue queue = new DataQueue();
        ReentrantLock locker = new ReentrantLock();
        Condition condition = locker.newCondition();
        Thread writersPoolFill = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                writersPool.execute(() -> {
                    locker.lock();
                    try {
                        queue.add(new Data(new int[]{1, 2, 3}));
                        System.out.println("Added 1, 2, 3");
                        condition.signal();
                    } finally {
                        locker.unlock();
                    }
                });
            }
        });
        Thread readersPoolFill = new Thread(() -> {
            for (int i = 0; i < readersNum; ++i) {
                readersPool.execute(() -> {
                    try {
                        while (true) {
                            locker.lock();
                            try {
                                while (queue.data.size() == 0) {
                                    if (!condition.await(100L, TimeUnit.MILLISECONDS)) {
                                        return;
                                    }
                                }
                                Data data = queue.get();
                                System.out.println("        Printed " + Arrays.toString(data.get()));
                            } finally {
                                locker.unlock();
                            }
                        }
                    } catch (Exception ignored) {

                    }
                });
            }
        });

        writersPoolFill.start();
        readersPoolFill.start();
        writersPoolFill.join();
        readersPoolFill.join();

        writersPool.shutdown();
        readersPool.shutdown();
    }
}
