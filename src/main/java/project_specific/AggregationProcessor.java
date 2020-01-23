/* 
User: Urmi
Date: 1/22/2020 
Time: 5:13 PM
*/

package project_specific;

import java.util.*;
import java.util.stream.Collectors;

import static project_specific.AggregationFile.PRODUCT_CSV;
import static project_specific.AggregationFile.TRADES_CSV;

public class AggregationProcessor<T> {

    public void runAggregation(String optimizedProblemId, String aggregatedProblemId){
        Map<String, RunType> tradeIdToMergeType = new HashMap<>();
        Map<String, RunType> cusipToMergeType = new HashMap<>();

        //create data universe
        if(aggregatedProblemId != null){
            tradeIdToMergeType = getMergeKeyToMergeType(optimizedProblemId, aggregatedProblemId, TRADES_CSV);
            cusipToMergeType = getMergeKeyToMergeType(optimizedProblemId, aggregatedProblemId, PRODUCT_CSV);
        }

        EnumMap<AggregationFile, List<T>> aggregatedResult = new EnumMap<>(AggregationFile.class);
        for(AggregationFile inputFile : AggregationFile.values()){
            List<T> aggregatedList = new ArrayList<>();//get this list
            List<T> optimizedList = new ArrayList<>();//get this list
            List<T> result = Aggregator.aggregateFiles(optimizedList, aggregatedList, inputFile, tradeIdToMergeType, cusipToMergeType);
            aggregatedResult.put(inputFile, result);
        }

        //once merging finishes, write the aggregated files to directory

    }

    private Map<String,RunType> getMergeKeyToMergeType(String optimizedProblemId, String aggregatedProblemId, AggregationFile inputFile) {
        List<T> aggregatedList = new ArrayList<>();//get this list
        List<T> optimizedList = new ArrayList<>();//get this list

        Map<String,RunType> map = new HashMap<>();
        map.putAll(aggregatedList.stream().collect(Collectors.toMap(inputFile::getMergeKey, t -> RunType.AGGREGATED)));
        map.putAll(optimizedList.stream().collect(Collectors.toMap(inputFile::getMergeKey, t -> RunType.OPTIMIZED)));

        return map;
    }
}
