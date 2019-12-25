package crackingcodeinterview;

public class StringCompress {

    //aabcccccaaa => a2b1c5a3
    private static String compress(String str){
        StringBuilder sb = new StringBuilder();
        int consecutiveCount = 0;
        for(int i = 0; i < str.length(); i++){
            consecutiveCount ++;
            if((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                sb.append(str.charAt(i));
                sb.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(compress("aabcccccaaa"));
    }
}