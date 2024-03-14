package tasks1_2_3;

public class NewThreadOne extends Thread {
    @Override
    public void run(){
        System.out.println("\nПервый поток");
    }
}
