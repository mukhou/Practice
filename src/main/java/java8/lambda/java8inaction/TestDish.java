package java8.lambda.java8inaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/21/18
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDish {

    public static void main(String[] args){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //low calorie dish
        List<String> lowCaloricDishesName =
                menu.stream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());

        //####################################################################################

        //dish by type
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        //####################################################################################

        //dish type count
        Map<Dish.Type, Long> dishTypeCount = menu.stream().collect(groupingBy(Dish::getType, counting()));


        //####################################################################################

        //three high calorie dishes
        List<String> threeHighCalorieDishes =
                menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(threeHighCalorieDishes);

        //####################################################################################

        //limit use
        List<String> names =
                menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        //####################################################################################

        //veg dishes
        List<Dish> vegetarianDishes =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());

        //count the number of dishes
        int dishCount = menu.stream().map(d -> 1).reduce(0, Integer::sum);

        //OR
        long discount1 = menu.stream().collect(counting());

        //OR
        long dishCount2 = menu.stream().count();


        //Note: always choose the most specialized one that’s general enough to solve it(in this case,
        // the last option using IntStream.

        //####################################################################################

        //total number of calories in menu
        //OR -- MOST OPTIMAL
        int totalCalories3 = menu.stream().mapToInt(Dish::getCalories).sum();

        //OR
        int totalCalories2 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

        //OR
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        //OR
        int totalCalories1 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));


        //####################################################################################

        //sum of all calories in dish
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();

        //####################################################################################

        //max calorie
        int maxCal = menu.stream().mapToInt(Dish::getCalories).max().orElse(1);

        //####################################################################################

        //max calorie dish
        //PREFERRED
        Optional<Dish> maxCalDish1 = menu.stream().collect(maxBy(comparingInt(Dish::getCalories)));

        //OR - create a Comparator for the field you want to compare, in this case, calorie
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        //pass in the comparator
        Optional<Dish> maxCalDish = menu.stream().collect(maxBy(dishComparator));

        //OR
        Optional<Dish> maxCalDish2 = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1: d2));

        //####################################################################################

        //max calorie dish by type
        //Note: maxBy(comparingInt(Dish::getCalories)) => this gives max calorie dish
        //so to group max calorie dish BY TYPE, just add a grouping beforehand using groupBy
        //and pass this as the second param of the groupBy method
        Map<Dish.Type, Optional<Dish>> mostCalorieByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        //OR
        Map<Dish.Type, Dish> mostCalorieByType1 = menu.stream()
                .collect(
                        groupingBy( Dish::getType,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        // In the above example, the collectingAndThen factory method, takes the following:
        //1. the collector to be adapted
        //2. a transformation function
        //and returns another collector. This additional collector acts as a wrapper for the old
        //one and maps the value it returns using the transformation function as the last step of the collect
        //operation. In this case, the wrapped collector is the one created with maxBy, and the
        //transformation function, Optional::get, extracts the value contained in the Optional returned

        //########################IMPORTANT########################
        /**
         * The process outlined in steps below:
         * 1. groupingBy is the outermost one and groups the menu stream into three substreams
         * according to the different dishes’ types.
         * 2. The groupingBy collector wraps the collectingAndThen collector, so each substream resulting
         * from the grouping operation is further reduced by this second collector.
         * 3. The collectingAndThen collector wraps in turn a third collector, the maxBy one. This reduction operation
         * on the substreams is then performed by the reducing collector, but the collectingAndThen collector
         * containing it applies the Optional::get transformation function to its result.
         */

        //####################################################################################

        //total calories by type
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        //####################################################################################

        //partition menu
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        //####################################################################################

        //partition by and collect
        Map<Boolean, Map<Dish.Type, List<Dish>>> menuByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }


}
