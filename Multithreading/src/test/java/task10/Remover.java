package task10;

public class Remover<K,V> extends Thread {
    private final MyConcurrentHashMap<K,V> map;
    private final K key;
    public Remover(MyConcurrentHashMap<K,V> map, K key){
        this.map = map;
        this.key = key;
    }

    @Override
    public void run(){
        map.remove(key);
//        System.out.println("remove from key = " + key);
    }
}
