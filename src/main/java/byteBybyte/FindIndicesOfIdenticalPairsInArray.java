/* 
User: Urmi
Date: 1/31/2020 
Time: 3:08 PM
*/

package byteBybyte;

import java.util.HashMap;
import java.util.Map;

public class FindIndicesOfIdenticalPairsInArray {
    private static int identicalPairs(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.merge(arr[i], 1, Integer::sum);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            count += (freq * (freq - 1)) / 2;
        }
        return count;
    }

    private static int identicalPairsBrute(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count ++;
                    if(count > 1000000000){
                        return 1000000000;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(identicalPairsBrute(new int[]{3, 5, 6, 3, 3, 5}));
        System.out.println(identicalPairs(new int[]{3, 5, 6, 3, 3, 5}));
    }
}
