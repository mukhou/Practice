package java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
    public static void main(String[] args){
        List<Integer> list = List.of(2, 3, 4, 5);
        System.out.println(list.stream()
                .filter(n -> n %2 == 0)
                .map(n -> n * 2)
                .filter(n -> n > 5)
                .findFirst().orElse(null));
        ;

        List<String> list1 = new ArrayList<>();
        list1.stream().forEach(System.out::println);
        list1.add("");
        List<String> list2 = new ArrayList<>();
        list2.add("");
        list2.addAll(list1);
        System.out.println(list2);
        System.out.println(list2.size());
    }
}
