/* 
User: Urmi
Date: 1/22/2020 
Time: 2:51 PM
*/

package byteBybyte;

import java.util.HashMap;
import java.util.Map;

public class Consensus {

    Map<String, Map<String, Float>> brokerMap = new HashMap<>();
    Map<String, Map<String, Float>> tickerMap = new HashMap<>();

    private void add(String broker, String ticker, float eps){
        if(brokerMap.containsKey(broker)){
            Map<String, Float> map = brokerMap.get(broker);
            map.put(ticker, eps);
        }else {
            Map<String, Float> map = new HashMap<>();
            map.put(ticker, eps);
            brokerMap.put(broker, map);
        }
    }

    private void addData(String broker, String ticker, float eps){
        if(tickerMap.containsKey(ticker)){
            Map<String, Float> map = tickerMap.get(ticker);
            if(map.containsKey(broker)){
                map.put(broker, eps);
            }else {
                Map<String, Float> map1 = new HashMap<>();
                map1.put(broker, eps);
                tickerMap.put(ticker, map1);
            }
        }else {
            Map<String, Float> map = new HashMap<>();
            map.put(broker, eps);
            tickerMap.put(ticker, map);
        }
    }

    private float get(String ticker){
        int count = 0;
        float res = 0;
        for(Map.Entry<String, Map<String, Float>> entry: brokerMap.entrySet()){
            if(entry.getValue().containsKey(ticker)){
                res += entry.getValue().get(ticker);
                count ++;
            }
        }
        return res / count;
    }
    public static void main(String[] args){
        Consensus consensus = new Consensus();
        consensus.add("GS", "IBM", 1.21F);
        consensus.add("Citi", "IBM", 1.40F);
        consensus.add("Citi", "IBM", 1.38F);
        System.out.println(consensus.brokerMap);
        System.out.println(consensus.get("IBM"));
        consensus.addData("GS", "IBM", 1.21F);
        consensus.addData("Citi", "IBM", 1.40F);
        consensus.addData("Citi", "IBM", 1.38F);
        System.out.println(consensus.tickerMap);

    }
}
