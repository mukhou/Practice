/* 
User: Urmi
Date: 1/25/2020 
Time: 5:35 PM
*/

package byteBybyte;

public class StringToBinary {
    private static void strToBinary(String s){
        for(int i = 0; i < s.length(); i++){
            int val = Integer.valueOf(s.charAt(i));
            String bin = "";
            while(val > 0){
                if(val % 2 == 1){
                    bin = '1' + bin;
                }else {
                    bin = '0' + bin;
                }
                val /= 2;
            }
            //bin = reverse(bin) + " ";
            System.out.print(bin + " ");

        }
    }

    public static void main(String[] args){
        strToBinary("123");
    }
}
