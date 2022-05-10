package anything;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/18/16
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringSplit {

    public static void main(String[] args){
        String str = "abc,def,mno,";
        List<String> l = Arrays.asList(str.split(","));
        System.out.println(l);
        for(String s : l){
            System.out.println(s);
        }
    }
}
