package bloomberg;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 6/29/15
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringToInteger {
    public static void main(String[] args){
        String str = "123";
        int result = 0;
        for(int i = 0; i <= str.length() - 1 ; i++){
            result *= 10;
            result += (str.charAt(i) - '0');
        }
        System.out.println(result);
    }
}
