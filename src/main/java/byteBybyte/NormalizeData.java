/* 
User: Urmi
Date: 1/31/2020 
Time: 3:28 PM
*/

package byteBybyte;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NormalizeData {
    private static Stream<BigDecimal> preProcess(Stream<BigDecimal> input){
        Stream<BigDecimal> valid = input.filter(bigDecimal -> bigDecimal.signum() >= 1);
        List<BigDecimal> list = valid.collect(Collectors.toList());
        if(list.size() < 3){
            return Stream.empty();
        }
        List<List<BigDecimal>> triplets = createTriplets(list);
        //filter
        triplets = triplets.stream().filter(bigDecimals -> isAboveThreshold(bigDecimals)).collect(Collectors.toList());
        //join
        List<BigDecimal> converted = triplets.stream().flatMap(List::stream).collect(Collectors.toList());
        return input;
    }

    private static List<List<BigDecimal>> createTriplets(List<BigDecimal> list) {
        List<List<BigDecimal>> triplets = new ArrayList<>();
        int end;
        if(list.size() % 3 == 0){
            end = list.size();
        }else if(list.size() % 3 == 1){
            end = list.size() - 1;
        }else {
            end = list.size() - 2;
        }
        for(int i = 0; i < end; i += 3){
            List<BigDecimal> each = new ArrayList<>();
            each.add(list.get(i));
            each.add(list.get(i + 1));
            each.add(list.get(i + 2));
            System.out.println(each);
            triplets.add(each);
        }
        return triplets;
    }

    private static boolean isAboveThreshold(List<BigDecimal> bigDecimals) {
        return bigDecimals.stream().mapToDouble(BigDecimal::doubleValue).average().getAsDouble() <= 30;
    }

    private static void triplet(int[] arr){
        List<List<Integer>> l = new ArrayList<>();
        int end = 0;
        if(arr.length % 3 == 0){
            end = arr.length;
        }else if(arr.length % 3 == 1){
            end = arr.length - 1;
        }else {
            end = arr.length - 2;
        }
        for(int i = 0; i < end; i += 3){
            List<Integer> l1 = new ArrayList<>();
            l1.add(arr[i]);
            l1.add(arr[i + 1]);
            l1.add(arr[i + 2]);
            System.out.println(l1);
            double s = l1.stream().mapToInt(Integer::intValue).average().getAsDouble();
            l.add(l1);
        }
        List<Integer> l2 = new ArrayList<>();
        l2 = l.stream().flatMap(List::stream).collect(Collectors.toList());


    }

    public static void main(String[] args){
        Stream.Builder<BigDecimal> builder = Stream.builder();
        Stream<BigDecimal> stream = builder.add(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(200))
                .add(BigDecimal.valueOf(300))
                .add(BigDecimal.valueOf(0)).add(BigDecimal.valueOf(-30)).build();
        System.out.println(preProcess(stream));
        triplet(new int[]{100, 200, 300, 400, 500, 600});
    }
}
