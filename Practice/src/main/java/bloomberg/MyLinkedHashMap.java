package bloomberg;

public class MyLinkedHashMap<K, V> {

    private static class Entry<K, V> extends MyHashMap.Entry<K, V>{

        MyLinkedHashMap.Entry<K, V> before, after;

        Entry(K key, V value, MyLinkedHashMap.Entry<K, V> next, int hash){
            super(key, value, hash, next);
        }

        /**
         * The head (eldest) of the doubly linked list.
         */
        transient Entry<K,V> head;

        /**
         * The tail (youngest) of the doubly linked list.
         */
        transient Entry<K,V> tail;

    }

    private Entry<K, V>[] table;


}


