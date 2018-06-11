package conceptual;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/23/18
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestList {
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        list.add(0, 11);
        System.out.println(list);
    }
}
