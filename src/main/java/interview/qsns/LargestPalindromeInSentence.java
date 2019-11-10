package interview.qsns;

public class LargestPalindromeInSentence {

    public int palindrome(String sentence) throws NullPointerException{
        boolean b = false;
        int length = 0;
        String[] words = sentence.split(" ");
        // use two variables
        for(int l = 0; l <= words.length - 1; l++){
            int temp = 0;
            String word = words[l];
            System.out.println(word);
            for(int i = word.length()-1, j=0; i>=0; i--, j++){
                if(Character.toString(word.charAt(i)).
                        equals(Character.toString(word.charAt(j)))){
                    temp++;
                    if(i==j){
                        b = true;
                        break;
                    }
                    //continue;
                }else{
                    b = false;
                    break;
                }
            }
            length = length > temp ? length : temp;
        }


        return length;
    }

    public static void main(String[] args) {

        LargestPalindromeInSentence pal = new LargestPalindromeInSentence();
        System.out.println(pal.palindrome("basab malayalam panamalamanap"));


    }
}
