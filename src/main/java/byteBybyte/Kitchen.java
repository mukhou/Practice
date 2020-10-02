/* 
User: Urmi
Date: 2/2/2020 
Time: 3:00 PM
*/

//JP Morgan & Chase interview coding challenge
package byteBybyte;

import java.util.*;
import java.util.stream.Collectors;

public class Kitchen {
    //Tina, 5, FS
    //Tina, 5, FF
    //Susan, 5, FF
    private static void show(List<String> orders) {
        Map<String, Map<String, Integer>> map = createOrders(orders);
        //all table numbers
        List<String> tables = new ArrayList<>(map.keySet());
        List<String> allItems;
        allItems = map.entrySet().stream().map(entry -> entry.getValue().keySet())
                .flatMap(Collection::stream).collect(Collectors.toList());
        //O/P
        List<String> headers = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        str.append("Table");
        for (int i = 0; i < allItems.size(); i++) {
            str.append(",").append(allItems.get(i));

        }
        headers.add(str.toString());
        List<String> data = new ArrayList<>();
        for (String table : tables) {
            StringBuilder tableNum = new StringBuilder();
            tableNum.append(table);
            for(String item: allItems){
                Map<String, Integer> inner = map.get(table);
                if(inner.containsKey(item)){
                    tableNum.append(",").append(inner.get(item));
                }else {
                    tableNum.append(",").append("0");
                }
            }
            data.add(tableNum.toString());

        }

        headers.addAll(data);
       // System.out.println(headers);
        for(String s : headers){
            System.out.println(s);
        }
    }

    private static Map<String, Map<String, Integer>> createOrders(List<String> orders) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (String order : orders) {
            String[] arr = order.split(",");
            String table = arr[1];
            String item = arr[2];
            if (map.containsKey(table)) {
                Map<String, Integer> item_count = map.get(table);
                item_count.merge(item, 1, Integer::sum);
            } else {
                Map<String, Integer> item_count = new HashMap<>();
                item_count.put(item, 1);
                map.put(table, item_count);
            }

        }
        return map;

    }

    public static void main(String[] args) {
        List<String> ordrs = Arrays.asList("Tina,5,FF", "Tina,5,FS", "Paul,5,FF", "Susan,5,FF", "John,11,CS");
        show(ordrs);
    }
}

