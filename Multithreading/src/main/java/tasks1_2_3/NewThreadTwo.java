package tasks1_2_3;

public class NewThreadTwo extends Thread{
    @Override
    public void run() {
        System.out.println("\nВторой поток");
    }
}
