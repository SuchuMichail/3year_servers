package tasks123;

public class Task123 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().isDaemon());//демон ли?
        System.out.println(Thread.currentThread().isAlive());//поток используется?
        System.out.println(Thread.currentThread().isInterrupted());//прерван ли?
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getState());

        System.out.println();

        Runnable runner = () -> System.out.println("Побочный поток");
        Thread thread = new Thread(runner);
        thread.start();
        thread.join();

        NewThreadOne one = new NewThreadOne();
        NewThreadTwo two = new NewThreadTwo();
        NewThreadThree three = new NewThreadThree();

        one.start();
        two.start();
        three.start();

        one.join();
        two.join();
        three.join();

        System.out.println("\nGeneral thread finished");
    }
}
