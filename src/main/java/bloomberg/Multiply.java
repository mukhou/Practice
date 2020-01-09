package bloomberg;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/3/18
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Multiply {
    static int multiplyRecursive(int x, int y){
        if(y == 0){
            return 0;
        }
        if(y > 0){
            return (x + multiplyRecursive(x, y - 1));
        }
        if(y < 0){
            return  -multiplyRecursive(x, -y);
        }
        return -1;
    }
    static int multiplyIterative(int x, int y){

        int res = 0;
        if(y == 0){
            return 0;
        }
        while(y > 0){
            res +=x;
            y = y -1;
        }

        if(y < 0){
            y = -y;
            while(y > 0){
                res +=x;
                y = y -1;
            }
            res = -res;
        }
        return res;
    }
    public static void main(String[] args) {

        //System.out.print("\n" + multiplyRecursive(5, -11));
        System.out.print("\n" + multiplyIterative(5, -11));

        try(FileOutputStream fos = new FileOutputStream("sdfks");
            DataOutputStream dos = new DataOutputStream(fos)){

        }catch (IOException e){

        }
    }
}
