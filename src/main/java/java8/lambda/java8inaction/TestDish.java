package java8.lambda.java8inaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
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

        //dish by type
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        //three high calorie dishes
        List<String> threeHighCalorieDishes =
                menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(threeHighCalorieDishes);

        //limit use
        List<String> names =
                menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

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

        //total number of calories in menu
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        //OR
        int totalCalories1 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));

        //OR
        int totalCalories2 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

        //OR -- MOST OPTIMAL
        int totalCalories3 = menu.stream().mapToInt(Dish::getCalories).sum();

        //sum of all calories in dish
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();

        //max calorie
        int maxCal = menu.stream().mapToInt(Dish::getCalories).max().orElse(1);

        //max calorie dish
        //create a Comparator for the field you want to compare, in this case, calorie
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        //pass in the comparator
        Optional<Dish> dish = menu.stream().collect(maxBy(dishComparator));
    }


}
