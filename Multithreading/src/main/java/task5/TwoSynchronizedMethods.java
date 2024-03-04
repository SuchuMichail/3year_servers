package task5;

import task5.CommonResource;

public class TwoSynchronizedMethods extends Thread{
    private final CommonResource list;
    private final boolean isAdder;
    private final int count;

    public TwoSynchronizedMethods(CommonResource list, int count, boolean isAdder){
        this.list = list;
        this.count = count;
        this.isAdder = isAdder;
    }


    @Override
    public void run(){
        if(isAdder){
            for(int i = 0; i < count; i++){
                list.addRandomInt();
            }
        }else{
            for(int i = 0; i < count; i++){
//                while(list.size() == 0){
//                    Thread.yield();
//                }
                list.deleteFromRandomIndex();
            }
        }
    }
}
