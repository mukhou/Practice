package conceptual;


import java.util.HashSet;
import java.util.LinkedHashSet;

public class TestWrapper {
    public static void main(String[] args) {
        Integer i = new Integer(5);
        Integer j = new Integer(5);
        System.out.println(i==j); //false
        Integer a = 10;
        Integer b = 10;
        System.out.println(a==b); //true
        HashSet<String> s;
        LinkedHashSet<String> s1;
    }

}
