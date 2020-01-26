package byteBybyte;

public class LargestPalindromeInSentence {

    public int palindrome(String sentence) throws NullPointerException{
        int length = 0;
        String[] words = sentence.split(" ");
        for(int l = 0; l < words.length; l++){
            String word = words[l];
            System.out.println(word);
            int i = 0, n = word.length() - 1;
            int temp = word.length();
            while (i < n){
                if(word.charAt(i) != word.charAt(n)){
                    temp = 0;
                    break;
                }
                i ++;
                n --;
            }
            length = Math.max(length, temp);
        }


        return length;
    }

    public static void main(String[] args) {

        LargestPalindromeInSentence pal = new LargestPalindromeInSentence();
        System.out.println(pal.palindrome("basab malayalam panamalamanap"));


    }
}
