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
                if(val %2 == 1){
                    bin += '1';
                }else {
                    bin += '0';
                }
                val /= 2;
            }
            bin = reverse(bin);
            System.out.println(bin);

        }
    }

    private static String reverse(String input){
        char[] a = input.toCharArray();
        int l, r = 0;
        r = a.length - 1;

        for (l = 0; l < r; l++, r--)
        {
            // Swap values of l and r
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }
}
