import java.util.*;
import java.util.stream.Collectors;

public class FindMedian {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }
        findMedian(a);
    }

    private static void findMedian(int[] a) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        double result;
        for(int i=0; i<a.length; i++){

            maxheap.offer(a[i]);
            minheap.offer(maxheap.poll());

            if(minheap.size()>maxheap.size()){

                maxheap.offer(minheap.poll());
            }

            if(minheap.size()==maxheap.size()){
                result = ((double)(minheap.peek()+maxheap.peek()))/2;
            }
            else result = (double) maxheap.peek();

            System.out.println(result);

        }
    }
}
