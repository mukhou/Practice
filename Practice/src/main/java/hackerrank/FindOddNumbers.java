package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindOddNumbers {


    static int[] oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++){
            if(i % 2 != 0){
                list.add(i);
            }
        }
        System.out.println(list);
        int[] res  = new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            res[i] = list.get(i);
        }
        return res;


    }

    public static void main(String[] args){
        oddNumbers(2, 5);

    }
}
