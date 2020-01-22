/* 
User: Urmi
Date: 1/22/2020 
Time: 3:52 PM
*/

package project_specific;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static project_specific.RunType.AGGREGATED;
import static project_specific.RunType.OPTIMIZED;

//@Service
public class Aggregator {

    public static <T> List<T> aggregateFiles(List<T> optimisedList, List<T> aggregatedList, AggregationFile inputFile,
                                             Map<String, RunType> tradeIdToRynType,
                                             Map<String, RunType> cusipToRunType){

        Map<String, List<T>> mergeKeyToOptimizedObject = optimisedList.stream().collect(Collectors.groupingBy(inputFile::getMergeKey));
        Map<String, List<T>> mergeKeyToAggregatedObject = aggregatedList.stream().collect(Collectors.groupingBy(inputFile::getMergeKey));
        return inputFile.getMergeKeyType().equals(MergeKeyType.TRADE_ID)
               ? createResultList(mergeKeyToOptimizedObject, mergeKeyToAggregatedObject, tradeIdToRynType)
                : inputFile.getMergeKeyType().equals(MergeKeyType.CUSIP) ?
                createResultList(mergeKeyToOptimizedObject, mergeKeyToAggregatedObject, cusipToRunType)
                : null;
    }

    private static <T> List<T> createResultList(Map<String,List<T>> mergeKeyToOptimizedObject,
                                                Map<String,List<T>> mergeKeyToAggregatedObject,
                                                Map<String,RunType> mergeTypeMap) {
        List<T> result = new ArrayList<>();
        result.addAll(mergeKeyToOptimizedObject.entrySet().stream().filter(entry ->
        mergeTypeMap.get(entry.getKey()).equals(OPTIMIZED))
                .flatMap(t -> t.getValue().stream()).collect(Collectors.toList()));
        result.addAll(mergeKeyToAggregatedObject.entrySet().stream().filter(entry ->
                mergeTypeMap.get(entry.getKey()).equals(AGGREGATED))
                .flatMap(t -> t.getValue().stream()).collect(Collectors.toList()));

        return result;
    }
}
