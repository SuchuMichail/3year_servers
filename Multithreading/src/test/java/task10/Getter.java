package task10;

public class Getter<K,V> extends Thread {
    private final MyConcurrentHashMap<K,V> map;
    private final K key;
    public Getter(MyConcurrentHashMap<K,V> map, K key){
        this.map = map;
        this.key = key;
    }

    @Override
    public void run(){
        V value = map.get(key);
//        System.out.println("get value = " + value + " from key = " + key);
    }
}
