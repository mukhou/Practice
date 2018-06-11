package hackerrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestConcurrentModEx {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("skdfj");
        list.add("iuu");
        list.add("skbndnbdfj");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            list.remove(2);
        }
    }
}
