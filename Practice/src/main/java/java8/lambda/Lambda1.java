package java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * The basic syntax of a lambda is either:
 (parameters) ->expression  OR     (parameters) ->{ statements; }
 Examples:
 1. () -> 5          // takes no value and returns 5
 2. x -> 2 * x        // takes a number and returns the result of doubling it
 3. (x, y) -> x – y         // takes two numbers and returns their difference
 4. (int x, int y) -> x + y // takes two integers and returns their sum
 5.  (String s) -> System.out.print(s)   // takes a string and prints it to console without returning anything
 */

public class Lambda1 {

    public static void main (String args[]){
        String[] studentNames = {"Jeet", "Harsh", "Merry", "David", "Roger", "Andy ", "Tomas", "John"};
        List<String> students =  Arrays.asList(studentNames);

        //old looping
        for(String student : students){
            System.out.print(student + ", ");

        }
        System.out.println();

        //Lambda way
        System.out.println("print using lambda");
        students.forEach((s) -> System.out.print(s + ", "));
        System.out.println();
        //using double colon operator
        System.out.println("using double colon");
        students.forEach(System.out::print);

    }



}
