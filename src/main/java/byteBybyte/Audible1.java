/* 
User: Urmi
Date: 1/17/2020 
Time: 4:13 PM
*/

package byteBybyte;

import java.lang.reflect.Array;
import java.util.*;

public class Audible1 {

    public static ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests){
        ArrayList<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if(possibleFeatures.isEmpty()){
            return new ArrayList<>(Collections.emptyList());
        }
        for(String sentence : featureRequests){
            findCount(map, sentence, possibleFeatures);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> c = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, c.reversed());

        for(int i = 0; i < topFeatures; i++){
            result.add(list.get(i).getKey());
        }

        return result;
    }

    private static void findCount(Map<String,Integer> map, String requestString, List<String> possibleFeatures) {
        for(String feature: possibleFeatures){
            if(requestString.contains(feature)){
                map.merge(feature, 1, Integer::sum);
            }
        }
    }

    public static void main(String[] args){
        List<String> features = Arrays.asList("ana", "beta", "cetra", "delta", "euro");
        List<String> requests = Arrays.asList("ana ana", "beta", "delta and beta", "cetra and euro", "beta and delta");
        System.out.println(popularNFeatures(5, 2, features, 5, requests));


    }
}
