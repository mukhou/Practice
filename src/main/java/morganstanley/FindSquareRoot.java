package morganstanley;

public class FindSquareRoot {


    //Time complexity: O(log(num))
    //https://www.geeksforgeeks.org/square-root-of-an-integer/
    public static double Sqrt1(int x) {

        // Base cases
        if (x == 0 || x == 1)
            return x;

        // Staring from 1, try all numbers until
        // i*i is greater than or equal to x.
        int i = 1, result = 1;

        while (result <= x) {
            result = i * i;
            i++;
        }
        return i - 1;

    }

    //Time complexity: O(log(num))
    public static double Sqrt(int num) {
        //base case
        if (num == 0 || num == 1) {
            return num;
        }
        int start = 1, end = num, ans = 0;
        while (start <= end) {
            int guess = (start + end) / 2; //mid point
            //num is a perfect square
            if (guess * guess == num) {
                return guess;
            } else {
                if (guess * guess < num) { //too low
                    start = guess + 1;
                    ans = guess;
                } else {
                    end = guess - 1;
                }
            }

        }
        return ans;
    }


    public static void main(String[] args) {
		/*int num = 34;
		int guess = 1;
		while(0.0001 < Math.abs(guess * guess - num)){
		    guess = (guess + num / guess) / 2;		    
		}
		System.out.println(Integer.toString(guess));*/
        System.out.println(Sqrt(34));
        System.out.println(Sqrt1(34));
        System.out.println(Math.sqrt(34));
    }

}
