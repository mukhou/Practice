package conceptual;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 9/12/15
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class SampleTest {
    private static final char SEPARATOR = 0x20;
    private static final int MESSAGE_TYPE = 1;

    void login() {

        System.out.println(SEPARATOR + MESSAGE_TYPE + "=A");

    }

    public static void main(String[] args){
        SampleTest sampleTest = new SampleTest();
        sampleTest.login();
    }
}
