package byteBybyte;

public class NumberPalindrome {
    public static boolean isPalindrome(int n){
        if(n < 0){
            return false;
        }
        int temp = n;
        int sum = 0;
        while(temp != 0){
            sum = (sum * 10) + (temp % 10);
            temp /= 10;
        }
        if(sum == n){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(123454321));
    }
}
