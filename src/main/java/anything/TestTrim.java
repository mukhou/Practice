package anything;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/8/15
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTrim {
    public static void main(String[] args){
        String str = "          ";
        String a = str.trim();
        System.out.println("############### a is ");
        System.out.println(a);

        String test1 = "abc\n"
                + "def";
        System.out.println(test1.length() + "$$$$$$$$$$$$");
    }
}
