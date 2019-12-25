package hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/poisonous-plants/problem
 */

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++){
            list.add(in.nextInt());
            map.put(p[i], i + 1);
        }
        int result = poisonousPlants(list, map);
        System.out.println(result);
        in.close();
    }

    private static int poisonousPlants(List<Integer> list, Map<Integer, Integer> map) {
        int days = 0;
        int start = 0;
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0));
        int moreDying = 0;
        /*while(moreDying){
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) < list.get(start)){
                    temp.add(list.get(i));
                    moreDying = false;
                }else {
                    moreDying = true;
                }
                start++;
            }
            list = temp;
            System.out.println(list);
            days++;
            System.out.println(days);
        }*/


        return days;

    }
}
