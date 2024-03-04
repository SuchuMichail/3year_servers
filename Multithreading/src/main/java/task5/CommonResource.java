package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonResource {
    private final List<Integer> list;

    public CommonResource(List<Integer> list) {
        this.list = list;
    }

    public synchronized void deleteFromRandomIndex(){
        if(list.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Random random = new Random();
        int index = random.nextInt(list.size());
        list.remove(index);

        System.out.println("                        я делитнул с позиции " + index);
    }

    public synchronized void addRandomInt(){
        Random random = new Random();
        int x = random.nextInt();
        list.add(x);

        this.notify();

        System.out.println("*****" + x);
    }

    public synchronized int size(){
        return list.size();
    }

}
