package morganstanley;

public class FindSquareRoot {

    //Time complexity: O(log(num))
    //FOLLOW THIS
    public static double Sqrt(int num) {
        //base case
        if (num == 0 || num == 1) {
            return num;
        }
        int start = 1, end = num, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2; //mid point
            //num is a perfect square
            if (mid * mid == num) {
                return mid;
            } else {
                if (mid * mid < num) { //too low
                    start = mid + 1;
                    ans = mid;
                } else {
                    end = mid - 1;
                }
            }

        }
        return ans;
    }



    //BAD APPROACH
    //Time complexity: O(√ n).
    //https://www.geeksforgeeks.org/square-root-of-an-integer/
    public static double Sqrt1(int num) {

        // Base cases
        if (num == 0 || num == 1)
            return num;

        // Staring from 1, try all numbers until
        // i*i is greater than or equal to x.
        int i = 1, result = 1;

        while (result <= num) {
            result = i * i;
            i++;
        }
        return i - 1;

    }

    public static void main(String[] args) {
        System.out.println(Sqrt(48));
        System.out.println(Sqrt1(48));
        System.out.println(Math.sqrt(48));
    }

}
