/* 
User: Urmi
Date: 1/15/2020 
Time: 4:37 PM
*/

/**
 * Given an array with positive integers as elements indicating the maximum length of a jump which can be made
 * from any position in the array. Check if it is possible to have a jumps combination so that you can
 * eventually reach the end of given array. Print “true” if it is possible, otherwise, print “false”.
 */
package byteBybyte;

//https://java2blog.com/check-if-possible-to-reach-end-given-array-by-jumping/
public class CanJumpToEndOfArray {


    //FOLLOW THIS: Iterative way: using dynamic programming
    //time complexity: O(n^2)
    private static boolean canJumpDynamic(int[] arr){

        //if first element is 0, no further jumps
        if(arr[0] == 0){
            return false;
        }

        // jumps[arr.length - 1] will hold the
        boolean[] jumps = new boolean[arr.length];
        /* first index is always reachable, as this is the position we start from*/
        jumps[0] = true;

        for(int currPos = 0; currPos < arr.length; currPos++){
            /* if the index we are currently at is not reachable from
             * 0th index, then we obviously can not make further jumps
             * from this position.
             * Also, number of jumps possible from the current position
             * needs to be greater than zero, as in case of zero, we can
             * not move to any other position by making a jump*/
            if(jumps[currPos] && arr[currPos] > 0){
                int maxJumps = arr[currPos];
                /* mark all the reachable positions from current position
                 * true because, if they can be reached from an intermediate
                 * spot, and that intermediate spot can be reached from zero,
                 * then the jumped position will also be reachable from zeroth
                 * index*/
                for(int jump = 1; jump <= maxJumps; jump ++){
                    //check if within array bounds
                    if(currPos + jump < arr.length){
                        jumps[currPos + jump] = true;
                    }
                }

            }
        }

        return jumps[arr.length - 1];
    }

    //brute force solution
    //time complexity: O(n^n)
    //initial call: canJump1(arr, 0)
    private static boolean canJump1(int[] arr, int currPos) {
        // Base case: when source and destination are same
        if(currPos == arr.length - 1){
            return true;
        }

        //if first element is 0, no further jumps
        if(arr[0] == 0){
            return false;
        }

        boolean result = false;
        int maxJumps = arr[currPos];
        //jump starts from 1 as we assume there will always at least one jump
        for(int jump = 1; jump <= maxJumps; jump ++){
            //if staying within bounds after the jump
            if(currPos + jump < arr.length){
                result = result || canJump1(arr, currPos + jump);
            }
        }
        return result;
    }

    // Driver code
    public static void main(String args[]){
        int arr[] = { 3, 2, 1, 0, 4 };
        int n = arr.length;
        System.out.println(canJump1(arr, 0));
        System.out.println(canJumpDynamic(arr));
    }


}
