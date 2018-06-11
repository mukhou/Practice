package bloomberg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args){
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(10);
        List<Integer> list = new ArrayList<>();
        iterator.forEachRemaining(list::add);
        System.out.println(list);
    }
}
