/* 
User: Urmi
Date: 12/19/2019 
Time: 5:06 PM
*/

package conceptual;

public class TestFinally {

    public static void main(String[] args) {
        bar();
    }

    private static void bar() {
        System.out.println("start bar");
        String v = foo();
        System.out.println(v);
        System.out.println("end bar");
    }

    private static String foo() {
        int x = 0;
        int y = 5;
        try {
            System.out.println("start try");
            int b = y / x;
            System.out.println("end try ");
            return "returned from try ";
        } catch (Exception ex) {
            System.out.println("catch");
            return lem() + " returned from catch";
        } finally {
            System.out.println("finally");
        }
    }

    private static String lem() {
        System.out.println("lem");
         return "return from lem";
    }

}
