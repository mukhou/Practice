package byteBybyte;

public class LargestPalindromeInSentence {

    public int palindrome(String sentence) throws NullPointerException{
        boolean b = false;
        int length = 0;
        String[] words = sentence.split(" ");
        // use two variables
        for(int l = 0; l <= words.length - 1; l++){
            String word = words[l];
            System.out.println(word);
            int i = 0, n = word.length() - 1;
            int temp = n + 1;
            while (i < n){
                if(word.charAt(i) != word.charAt(n)){
                    b = false;
                    break;
                }
                i ++;
                n --;
            }
            b = true;
            length = length > temp ? length : temp;
        }


        return length;
    }

    public static void main(String[] args) {

        LargestPalindromeInSentence pal = new LargestPalindromeInSentence();
        System.out.println(pal.palindrome("basab malayalam panamalamanap"));


    }
}
