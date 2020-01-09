/* 
User: Urmi
Date: 1/8/2020 
Time: 2:25 PM
*/

package hackerrank;

/**
 * The computational complexity of this algorithm is the same as the one of sieve of Eratosthenes for the
 * precomputation and constant for each query.
 */
//https://www.geeksforgeeks.org/find-highest-occurring-digit-prime-numbers-range/
public class HighestOccurringDigitForPrimeNumbersInRange {

    // Sieve of Eratosthenes
    public static void sieve(boolean[] prime, int n){
        for(int p = 2; p * p <= n; p++){
            if(!prime[p]){
                for(int i = p * 2; i <= n; i += p){
                    prime[i] = true;
                }
            }
        }
    }

    static int maxDigitInPrimes(int left, int right){
        boolean[] prime = new boolean[right + 1];

        sieve(prime, right);

        // Initialse frequency of all digit to 0.
        int[] frequency = new int[10];

        //start from left, go till right, as prime[] was built from left to right
        for(int i = left; i <= right; i++){
            if(!prime[i]){ //number is prime
               int p = i;
               while(p > 0){
                   //extract each digit
                   int val = p % 10;
                   frequency[val]++;
                   p /= 10;
               }
            }
        }

        int max = frequency[0], ans = 0;
        //iterate from 1 to 9
        for (int j = 1; j < 10; j++) {
            if (max <= frequency[j]) {
                max = frequency[j];
                ans = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int L = 1, R = 20;
        System.out.println(maxDigitInPrimes(L, R));
    }


}
