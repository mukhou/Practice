package java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 5/3/15
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserMapReduceTest {
    private static List<User> users = Arrays.asList(
            new User(1, "Steve", "Vai", 40),
            new User(4, "Joe", "Smith", 32),
            new User(3, "Steve", "Johnson", 57),
            new User(9, "Mike", "Stevens", 18),
            new User(10, "George", "Armstrong", 24),
            new User(2, "Jim", "Smith", 40),
            new User(8, "Chuck", "Schneider", 34),
            new User(5, "Jorje", "Gonzales", 22),
            new User(6, "Jane", "Michaels", 47),
            new User(7, "Kim", "Berlie", 60)
    );

    public static void main(String[] args) {
        oldJavaWay();
        newJavaWay();
    }

    private static void oldJavaWay() {
        int total = 0;

        for (User u : users) {
            total += u.age;
        }

        double average = (double)total / (double)users.size();

        System.out.println("OLDWAY Average User Age: " + average);
    }

    private static void newJavaWay() {
        // mapToInt produces an IntStream
        double average = users.parallelStream().mapToInt(u -> u.age).average().getAsDouble();

        System.out.println("NEWWAY Average User Age: " + average);
    }
}
