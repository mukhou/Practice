package hackerrank;

import java.util.*;

public class SortMap {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        map.put("rini", 3);
        map.put("jhini", 2);
        map.put("hena", 1);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        System.out.println(result);

    }
}

