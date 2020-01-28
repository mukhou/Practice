/* 
User: Urmi
Date: 12/20/2019 
Time: 1:55 PM
*/

package threads;

public class FizzBuzzMultithreaded {
    public static void main(String[] args) {
        int n = 100;//i -> i % 3 == 0 && i % 5 == 0
        Thread[] threads = {new Thread(new FizzBuzz(i -> i % 3 == 0 && i % 5 == 0, i -> "FizzBuzz", n)), //function to print
                new Thread(new FizzBuzz(i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz", n)),
                new Thread(new FizzBuzz(i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz", n)),
                new Thread(new FizzBuzz(i -> i % 3 != 0 && i % 5 != 0, i -> Integer.toString(i), n))};//the function converts integer to a string

        for (Thread thread : threads) {
            thread.start();
        }
    }


    }
