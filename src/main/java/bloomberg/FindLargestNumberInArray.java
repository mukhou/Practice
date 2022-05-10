package bloomberg;

public class FindLargestNumberInArray {
    public static void findLargestNumber(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args){
        findLargestNumber(new int[]{2, 1, 4, 15, 32, 15, 72});
    }
}
