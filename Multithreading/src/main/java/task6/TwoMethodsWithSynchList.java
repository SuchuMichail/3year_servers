package task6;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TwoMethodsWithSynchList extends Thread{
    private final List<Integer> list;
    private final boolean isAdder;
    private final int count;

    public TwoMethodsWithSynchList(List<Integer> list, boolean isAdder, int count){
        this.list = list;
        this.isAdder = isAdder;
        this.count = count;
    }

    @Override
    public void run(){
        if(isAdder){
            for(int i = 0; i < count; i++){
                Random random = new Random();
                int x = random.nextInt();
                list.add(x);
                System.out.println("*****" + x);
            }
        }else{
            for(int i = 0; i < count; i++){
                while(list.isEmpty()){
                    Thread.yield();
                }
                Random random = new Random();
                int index = random.nextInt(list.size());
                list.remove(index);
                System.out.println("        я делитнул с позиции " + index);
            }
        }
    }
}
