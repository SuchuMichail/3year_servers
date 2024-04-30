package experiment;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DataQueue {
    LinkedList<Data> data;

    public DataQueue() {
        this.data = new LinkedList<>();
    }

    public DataQueue(LinkedList<Data> data) {
        this.data = data;
    }

    public synchronized void add(Data data) {
        this.data.addLast(data);
    }

    public synchronized Data get() {
        try {
            return this.data.removeFirst();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }
}
