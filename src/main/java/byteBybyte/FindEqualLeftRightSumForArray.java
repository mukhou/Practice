/**
 * You are given an array of numbers. Find out the array index or position
 * where sum of numbers preceding the index is equals to
 * sum of numbers succeeding the index.
 */
package byteBybyte;

public class FindEqualLeftRightSumForArray {
	
	public static int findMiddleIndex(int[] arr) throws Exception{
		int start = 0;
		int end = arr.length - 1;		
		int sumLeft = 0;
		int sumRight = 0;
		while(true){
			if(sumLeft > sumRight){
				sumRight += arr[end --];
			}else{
				sumLeft += arr[start++];
			}
			if(start > end){
				if(sumLeft == sumRight){
					break;
				}else{
					throw new Exception("Not a proper array");
				}
			}
		}
		return end;
	}
	
	public static void main(String[] args) {
		int[] num = { 2, 4, 4, 5, 4, 1 };
        try {
            System.out.println("Starting from index 0, adding numbers till index "
                            + findMiddleIndex(num) + " and");
            System.out.println("adding rest of the numbers can be equal");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

	}

}
