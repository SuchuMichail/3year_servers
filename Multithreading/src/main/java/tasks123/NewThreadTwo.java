package tasks123;

public class NewThreadTwo extends Thread{
    @Override
    public void run() {
        System.out.println("\nВторой поток");
    }
}
