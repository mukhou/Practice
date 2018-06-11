package java8.lambda;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 5/3/15
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    Integer id;
    String firstName;
    String lastName;
    Integer age;

    User() {}
    User(int id, String first, String last, int age) {
        this.id = id;
        this.firstName = first;
        this.lastName = last;
        this.age = age;
    }

    public String toString() {
        return "" + id + ", " + firstName + ", " + lastName + ", " + age;
    }
}
