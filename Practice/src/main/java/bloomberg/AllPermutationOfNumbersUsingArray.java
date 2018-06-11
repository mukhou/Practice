package bloomberg;

public class AllPermutationOfNumbersUsingArray {
    static void permute(int[] arr, int k){
        if(k == arr.length){
            for(int i = 0; i < arr.length; i++){
                System.out.print(" [" + arr[i] + "] ");
            }
            System.out.println();
        }else {
            for(int i = k; i < arr.length; i++){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;

                permute(arr, k + 1);

                 temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }

    }

    public static void main(String args[]) {
        int N = 3;
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = i + 1;
        }

        permute(sequence, 0);

    }
}
