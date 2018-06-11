package bloomberg;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExcelManipuation {

    public static String toName(int number) {
        StringBuilder sb = new StringBuilder();
        //JUST LIKE String to integer conversion, integer reversal
        while (number-- > 0) {
            sb.append((char)('A' + (number % 26)));
            number /= 26;
        }
        return sb.reverse().toString();
    }

    public static int toNumber(String name) {
        int number = 0;
        for (int i = 0; i < name.length(); i++) {
            number = number * 26 + (name.charAt(i) - ('A' - 1));
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(toName(32));
        System.out.println(toNumber("AF"));
    }
}
