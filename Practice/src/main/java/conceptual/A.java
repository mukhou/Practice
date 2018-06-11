package conceptual;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 9/12/15
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class A {
    public static void main(String[] args) {


            final List<Integer> list = new ArrayList<Integer>();

            Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

            final Integer pos = Integer.valueOf(3);

            list.remove(pos);

            System.out.println(list);

        }
}