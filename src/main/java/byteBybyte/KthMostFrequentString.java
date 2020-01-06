/* 
User: Urmi
Date: 1/4/2020 
Time: 9:34 AM
*/

package byteBybyte;

import java.util.*;

//https://www.byte-by-byte.com/kthmostfrequentstring/
public class KthMostFrequentString {

    public static String kthMostFreQuent(String[] strings, int k){

        Map<String, Integer> map = new HashMap<>();
        for(String s : strings){
            map.merge(s, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        //old java way
        /*Collections.sort(list, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                Integer v1 = (Integer) o1.getValue();
                Integer v2 = (Integer) o2.getValue();
                return v1.compareTo(v2);
            }
        });
*/


        if(list.size() > k){
            return (list.get(k)).getKey();
        }else {
            return null;
        }
    }

    public static void main (String[]args){
        System.out.println(kthMostFreQuent(new String[]{"a", "a", "b"}, 1));

    }
}