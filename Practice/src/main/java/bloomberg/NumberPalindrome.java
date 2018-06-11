package bloomberg;

public class NumberPalindrome {
    public static boolean isPalindrome(int n){
        int temp = n;
        int sum = 0;
        while(n != 0){
            sum = (sum * 10) + (n % 10);
            n /= 10;
        }
        if(sum == temp){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(123454320));
    }
}
