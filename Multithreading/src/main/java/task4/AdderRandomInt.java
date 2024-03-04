package task4;

import java.util.ArrayList;
import java.util.Random;

public class AdderRandomInt extends Thread{
    private final ArrayList<Integer> list;
    private final int count;

    public AdderRandomInt(ArrayList<Integer> list, int count){
        this.list = list;
        this.count = count;
    }

    @Override
    public void run(){
        for(int i = 0; i < count; i++) {
            synchronized (list) {
                Random random = new Random();
                int x = random.nextInt();
                list.add(x);
                System.out.println("***** " + i + ") " + x);
                list.notify();
            }
        }
    }
}
