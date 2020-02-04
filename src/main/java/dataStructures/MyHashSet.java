/* 
User: Urmi
Date: 12/23/2019 
Time: 9:04 AM
*/

//https://www.geeksforgeeks.org/internal-working-of-sethashset-in-java/
package dataStructures;

public class MyHashSet<K> {

    private MyHashMap<K, Object> myHashMap;

    private static final Object PRESENT = new Object();

    public MyHashSet(MyHashMap<K, Object> myHashMap){
        this.myHashMap = myHashMap;
    }

    /**
     * In a HashMap each key is unique and when we call put(Key, Value) method, it returns the previous value associated with key,
     * or null if there was no mapping for key.
     * So in addCharacter() method we check the return value of map.put(key, value) method with null value.
     * If map.put(key, value) returns null, then the statement “map.put(e, PRESENT) == null” will return true
     * and element is added to the HashSet(internally HashMap).
     * If map.put(key, value) returns old value of the key, then the statement “map.put(e, PRESENT) == null” will return false
     * and element is not added to the HashSet(internally HashMap).
     * @param k
     * @return
     */
    public boolean add(K k){
        return myHashMap.put(k, PRESENT) == null;
    }

}
