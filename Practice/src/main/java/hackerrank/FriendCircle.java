package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 9/7/15
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class FriendCircle {

    public static void findFriends(String[] arr){
        int rows = arr.length;
        int cols = arr[0].length();
        int count = 0;
        String str0 = arr[0];
        String str1 = arr[1];
        for(int i = 0; i < str0.length(); i++){
           if(str0.charAt(i) == str1.charAt(i)){
               count ++;
           }
        }

        System.out.println(count);



    }

    public static void main(String[] args) {
        String[] arr= new String[]{
                "YYNN",
                "YYYN",
                "NYYN",
                "NNNY"
        };


        findFriends(arr);


    }
}
