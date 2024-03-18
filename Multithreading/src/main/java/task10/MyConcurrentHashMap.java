package task10;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyConcurrentHashMap<K,V> {
    private final int initialCapacity;
    private final List<HashMap<K,V>> arrayMaps;
    private final ReadWriteLock[] locks;

    public MyConcurrentHashMap(){
        this(16);
    }
    public MyConcurrentHashMap(int initialCapacity){
        this.initialCapacity = initialCapacity;
        this.arrayMaps = new ArrayList<>(initialCapacity);
        this.locks = new ReentrantReadWriteLock[initialCapacity];

        for(int i=0;i<initialCapacity;i++){
            this.arrayMaps.add(new HashMap<>());
            this.locks[i] = new ReentrantReadWriteLock();
        }
    }
    public void put(K key, V value){
        int numberOfSegment = key.hashCode() % initialCapacity;
        HashMap<K,V> map = arrayMaps.get(numberOfSegment);
        Lock writeLockkk = locks[numberOfSegment].writeLock();
        try{
            writeLockkk.lock();
            arrayMaps.get(numberOfSegment).put(key,value);
            System.out.println("put value = " + value + " to key = " + key);
        } finally {
            writeLockkk.unlock();
        }
    }

    public V remove(K key){
        int numberOfSegment = key.hashCode() % initialCapacity;
        HashMap<K,V> map = arrayMaps.get(numberOfSegment);
        Lock writeLockkk = locks[numberOfSegment].writeLock();
        V result;
        try {
            writeLockkk.lock();
            result = arrayMaps.get(numberOfSegment).remove(key);
            System.out.println("remove from key = " + key);
        } finally {
            writeLockkk.unlock();
        }
        return result;
    }

    public V get(K key){
        int numberOfSegment = key.hashCode() % initialCapacity;
        HashMap<K,V> map = arrayMaps.get(numberOfSegment);
        Lock readLockkk = locks[numberOfSegment].readLock();
        V result;
        try{
            readLockkk.lock();
            result = arrayMaps.get(numberOfSegment).get(key);
            System.out.println("get value = " + result + " from key = " + key);
        } finally {
            readLockkk.unlock();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyConcurrentHashMap<?, ?> that = (MyConcurrentHashMap<?, ?>) o;
        return initialCapacity == that.initialCapacity && Objects.equals(arrayMaps, that.arrayMaps) && Arrays.equals(locks, that.locks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(initialCapacity, arrayMaps);
        result = 31 * result + Arrays.hashCode(locks);
        return result;
    }
}
