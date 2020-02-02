/* 
User: Urmi
Date: 2/2/2020 
Time: 5:57 PM
*/

package dataStructures;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeLinkedList<T> {

    private java.util.LinkedList<T> list = new java.util.LinkedList<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(T t){
        lock.writeLock().lock();
        list.add(t);
        lock.writeLock().unlock();
    }

    public void add(T t, int index){
        lock.writeLock().lock();
        list.add(index, t);
        lock.writeLock().unlock();
    }

    public T get(int index) {
        T t;
        lock.readLock().lock();
        t = list.get(index);
        lock.readLock().unlock();
        return t;
    }

    public T getFirst() {
        T t;
        lock.readLock().lock();
        t = list.getFirst();
        lock.readLock().unlock();
        return t;
    }

    public T getLast() {
        T t;
        lock.readLock().lock();
        t = list.getLast();
        lock.readLock().unlock();
        return t;
    }

    public int size() {
        int size;
        lock.readLock().lock();
        size = list.size();
        lock.readLock().unlock();
        return size;

    }
}
