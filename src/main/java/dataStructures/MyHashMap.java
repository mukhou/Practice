package dataStructures;


import java.util.HashMap;
import java.util.Objects;

public class MyHashMap<K, V> {

    public static class Entry<K, V> extends HashMap<K, V> {
        private final K key;
        V value;
        MyHashMap.Entry<K, V> next;
        MyHashMap.Entry<K, V> prev;
        int hash;

        Entry(K key, V value, int hash, MyHashMap.Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }


        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof MyHashMap.Entry) {
                MyHashMap.Entry<K, V> e = (MyHashMap.Entry<K, V>) o;
                if (Objects.equals(key, e.key) &&
                        Objects.equals(value, e.value))
                    return true;
            }
            return false;
        }

    }

    public MyHashMap() {

    }

    private Entry<K, V>[] table;

    //adding object

    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is
     * replaced.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
     * if there was no mapping for <tt>key</tt>. (A <tt>null</tt> return
     * can also indicate that the map previously associated
     * <tt>null</tt> with <tt>key</tt>.)
     */
    V put(K key, V value) {
        if (key == null || value == null) {
            return null;
        }
        //IMPORTANT: find index in table on where to put the entry by modulus
        int index = key.hashCode() % table.length;
        Entry first = table[index];
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            //overwrite old value
            if (e.hash == key.hashCode() && e.key.equals(key)) {
                e.value = value;
                return value;
            }
        }

        // new entry, i.e. this key not exist in map
        Entry<K, V> e = new Entry(key, value, key.hashCode(), first);
        //set the index of the entry in the entry array
        table[index] = e;
        return null;
    }


    private V get(K key) {

        if (key == null) {
            return null;
        }
        //find index in the table
        int index = key.hashCode() % table.length;
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == key.hashCode() && e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    private void remove(K key){
        if(key == null){
            return;
        }
        int index = key.hashCode() % table.length;
        for(Entry<K, V> e = table[index]; e != null ; e = e.next){
            if(e.hash == key.hashCode() && e.key.equals(key)){
                if(e.prev != null){
                    e.prev.next = e.next;
                    e.next = null;
                }else {//removing the head
                    e = e.next;
                }

                if(e.next != null){
                    e.next.prev = e.prev;
                }
            }
        }
    }
}
