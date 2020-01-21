/* 
User: Urmi
Date: 1/21/2020 
Time: 3:18 PM
*/

package crackingcodeinterview;

public class Testprefix {
    public static void main(String[] args){
        int i = 1;
        if(--i == 0){
            System.out.println("prefix");
            System.out.println(i);
        }

        i = 1;
        if(i-- == 0){
            System.out.println("postfix");
            System.out.println(i);
        }
        System.out.println();
    }
}
