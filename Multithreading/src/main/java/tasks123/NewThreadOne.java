package tasks123;

public class NewThreadOne extends Thread {
    @Override
    public void run(){
        System.out.println("\nПервый поток");
    }
}
