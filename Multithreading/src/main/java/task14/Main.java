package task14;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter count of executors");//у задач пула экзекюторов будет вызываться экзекьют
        int countOfExecutors = sc.nextInt();
        System.out.println("enter count of developers");
        int countOfDevelopers = sc.nextInt();

        TaskQueue taskQueue = new TaskQueue();
        ReentrantLock locker = new ReentrantLock();
        Condition condition = locker.newCondition();
        ExecutorService executorsPool = new ThreadPoolExecutor(countOfExecutors, countOfExecutors,
                30L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        ExecutorService developersPool = new ThreadPoolExecutor(countOfDevelopers, countOfDevelopers,
                30L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());//потоки, которые добавляют задачу в очередь

        Thread developersPoolFill = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                int finalI = i;
                developersPool.execute(() -> {
                    locker.lock();
                    try {
                        taskQueue.addTask(new Task(()->System.out.println("     Removed "+finalI)));
                        System.out.println("Added " + finalI);
                        condition.signal();
                    } finally {
                        locker.unlock();
                    }
                });
            }
        });

        Thread executorsPoolFill = new Thread(() -> {
            executorsPool.execute(() -> {
                while(true) {
                    locker.lock();
                    try {
                        while (taskQueue.isEmpty()) {
                            //condition.await();
                            if (!condition.await(100L, TimeUnit.MILLISECONDS)) {
                                return;
                            }
                        }
                        taskQueue.getTask().execute();
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    } finally {
                        locker.unlock();
                    }
                }
            });
        });

        developersPoolFill.start();
        executorsPoolFill.start();
        developersPoolFill.join();
        executorsPoolFill.join();

        executorsPool.shutdown();
        developersPool.shutdown();
    }
}
