package anything;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/9/15
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestPhoneSum {
    public static void main(String[] args){

        String str = "847-840-5324";
        String[] strArr = str.split("-");
        String fullPhoneNum = strArr[0]+strArr[1]+strArr[2];
        long sum = 0;
        long phoneNumInt = Long.parseLong(fullPhoneNum);
        findSumofNum(phoneNumInt);

    }

    private static void findSumofNum(long phoneNumInt) {
        long d, sum = 0;


        while(phoneNumInt > 0){
            d = phoneNumInt % 10;
            sum += d;
            // since d is of type int, so only the digit before decimal is kept
            // rest are discarded
            phoneNumInt /= 10;
        }

        System.out.println("Sum = " + sum);
    }

}
