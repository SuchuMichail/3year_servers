package task4;

import java.util.ArrayList;
import java.util.Random;

public class DeleterFromRandomIndex extends Thread{
    private final ArrayList<Integer> list;
    private final int count;

    public DeleterFromRandomIndex(ArrayList<Integer> list, int count){
        this.list = list;
        this.count = count;
    }

    @Override
    public void run(){
        for(int i = 0; i < count; i++) {
            synchronized (list) {
                Random random = new Random();
                if(list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int index = random.nextInt(list.size());
                list.remove(index);
                System.out.println("        я делитнул с позиции " + index);
            }
        }
    }
}
