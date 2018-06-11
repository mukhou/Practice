package algorithms;

public class ContiguousRangeMaxProductArray {

    public static double findMaxProduct1(int[] arr) {
        double result = 0, currProduct;
        int cursor = 0;
        while (cursor < arr.length - 1) {
            currProduct = arr[cursor];
            for (int i = cursor; i < arr.length - 1; i++) {
                currProduct = currProduct * arr[i + 1];
            }
            //result = currProduct;
            if (result < currProduct) {
                result = currProduct;
            }
            cursor++;
        }
        return result;

    }

    // INCORRECT returns -72, which is incorrect
    public static double findMaxProduct(int[] arr) {
        double currProduct;
        currProduct = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //check if reached the last element
            if (i == (arr.length - 1)) {
                double temp = currProduct * arr[i];
                if (currProduct < temp) {
                    currProduct = temp;
                }
            } else {
                currProduct = currProduct * arr[i];
                /*if(currProduct < prevProduct){
                    prevProduct = currProduct;
					
				}*/
            }

        }
        return currProduct;
    }


    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4};
        //int[] arr = {0, -1, 2, 3};
        //int[] arr = {2, -2, 3, -2};
        //int[] arr = {-1, 2, 3, -1, 2};
        int[] arr = {1, -1, 2, -2, 3};
        //int[] arr = {2, -5, 3};
        //System.out.println(findMaxProduct(arr));
        System.out.println(findMaxProduct1(arr));

    }

}
