package task13;

import java.util.LinkedList;

public class DataQueue {
    private final LinkedList<Data> dataQueue;

    public DataQueue(){
        this.dataQueue = new LinkedList<>();
    }

    public synchronized void addData(Data data){
        dataQueue.addLast(data);
    }

    public synchronized Data getData(){
        if(dataQueue.isEmpty()) return null;
        return dataQueue.removeFirst();
    }

    public synchronized boolean isEmpty(){
        return dataQueue.isEmpty();
    }
}
