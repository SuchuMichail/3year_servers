package task10;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyConcurrentHashMap<K, V> {
    private final int initialCapacity;
    private final List<HashMap<K, V>> arrayMaps;
    private final ReadWriteLock[] locks;

    public MyConcurrentHashMap() {
        this(16);
    }

    public MyConcurrentHashMap(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.arrayMaps = new ArrayList<>(initialCapacity);
        this.locks = new ReentrantReadWriteLock[initialCapacity];

        for (int i = 0; i < initialCapacity; i++) {
            this.arrayMaps.add(new HashMap<>());
            this.locks[i] = new ReentrantReadWriteLock();
        }
    }

    public void put(K key, V value) {
        int numberOfSegment = key.hashCode() % initialCapacity;
        final Lock writeLockkk = locks[numberOfSegment].writeLock();
        try {
            writeLockkk.lock();
            arrayMaps.get(numberOfSegment).put(key, value);
            System.out.println("put value = " + value + " to key = " + key);
        } finally {
            writeLockkk.unlock();
        }
    }

    public V remove(K key) {
        int numberOfSegment = key.hashCode() % initialCapacity;
        Lock writeLockkk = locks[numberOfSegment].writeLock();
        try {
            writeLockkk.lock();
            V result = arrayMaps.get(numberOfSegment).remove(key);
            System.out.println("remove from key = " + key);
            return result;
        } finally {
            writeLockkk.unlock();
        }
    }

    public V get(K key) {
        int numberOfSegment = key.hashCode() % initialCapacity;
        Lock readLockkk = locks[numberOfSegment].readLock();
        try {
            readLockkk.lock();
            V result = arrayMaps.get(numberOfSegment).get(key);
            System.out.println("get value = " + result + " from key = " + key);
            return result;
        } finally {
            readLockkk.unlock();
        }
    }
}
