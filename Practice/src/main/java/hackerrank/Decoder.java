package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Decoder {
    private static String encode(String text) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            c +=  c + i;
            b.append(c);
        }

        return b.reverse().toString();
    }

    private static String decode(String encodedMessage){
        StringBuilder b = new StringBuilder();
        for(int i = encodedMessage.length() - 1, j = 0; i >= 0; i --, j++){
            char c = encodedMessage.charAt(i);
            int ascii = (int) c;
            ascii = ascii - j;
            ascii = ascii / 2;
            char x = (char) ascii;
            //int ascii2 = (int) str;
            b.append(Character.toString(x));


        }
        String res = b.toString();
        // System.out.println(res);
        return res;

    }
    public static void main(String[] args){
        //System.out.println(encode("urmi"));
        System.out.println(decode(encode("urmi")));
        /*String res = encode("urmi");
        decode(res);*/

    }
}
