package hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/22/17
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeConversion {
    static String timeConversion(String s) throws ParseException{
        SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm:ssa");

        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm:ss");
        String res = "";

        try {
            res =  date24Format.format(date12Format.parse(s));
        } catch (ParseException e) {
            e.getMessage();
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = null;
        try {
            result = timeConversion(s);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(result);
        //String time = "07:05:45PM";

        //convert string to 12 hour date (am/pm)
        /*SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm:ssa");

        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm:ss");

        System.out.println(date24Format.format(date12Format.parse(time)));
*/

    }
}
