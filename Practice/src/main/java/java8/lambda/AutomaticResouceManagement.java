package java8.lambda;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 5/4/15
 * Time: 7:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class AutomaticResouceManagement {
    public void auto() {
        try (FileOutputStream fos = new FileOutputStream("abhi1.txt");
             DataOutputStream ds = new DataOutputStream(fos)) {
            ds.writeUTF("Java 8 automatic resource management");

        }  catch(IOException e){
            e.printStackTrace();
        }
    }
}
