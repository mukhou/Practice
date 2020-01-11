/* 
User: Urmi
Date: 1/10/2020 
Time: 8:40 AM
*/

package byteBybyte;

public class AddAngleBrackets {
    public static String solution(String angles) {
        char[] arr = angles.toCharArray();
        String temp = "";
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '>'){
                temp = addToBeginnging(angles);
            }else if(arr[i] == '<'){
                if(i == arr.length - 1){
                    angles += '>';
                }else if(arr[i + 1] != '>'){
                    angles += '>';
                }
            }
        }
        return temp + angles;

    }

    private static String addToBeginnging(String temp) {
        temp = "" + '<';
        return temp;

    }

    public static void main(String[] args) {
        System.out.println(solution("><<><"));
    }

}
