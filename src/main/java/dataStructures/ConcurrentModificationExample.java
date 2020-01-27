/* 
User: Urmi
Date: 1/27/2020 
Time: 10:27 AM
*/

package dataStructures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//VV IMP
public class ConcurrentModificationExample {
    public static void main(String[] args){
        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: "+myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            //IMP: modifying the map will NOT throw any exception as each segment is owned by a thread
            // and hence they can concurrently write to it
            if(key.equals("3")) myMap.put(key+"new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: "+myMap);

        //HashMap
        myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: "+myMap);
        Iterator<String> it1 = myMap.keySet().iterator();

        while(it1.hasNext()){
            String key = it1.next();
            //IMP: this will throw exception(WITHOUT break) as its not thread safe
            if(key.equals("3")) {
                //add new entry and break will cause NO EXCEPTION
                myMap.put(key+"new", "new3");
                //updating entry instead of adding new
                myMap.put(key, "new3");
               // break;
            }

        }
        System.out.println("HashMap after iterator: "+myMap);
    }
}
