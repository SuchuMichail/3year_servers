package task10;

public class Putter<K,V> extends Thread {
    private final MyConcurrentHashMap<K,V> map;
    private final K key;
    private final V value;
    public Putter(MyConcurrentHashMap<K,V> map, K key, V value){
        this.map = map;
        this.key = key;
        this.value = value;
    }

    @Override
    public void run(){
        map.put(key,value);
//        System.out.println("put value = " + value + " to key = " + key);
    }
}
