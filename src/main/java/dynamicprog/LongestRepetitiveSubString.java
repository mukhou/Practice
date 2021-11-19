/* 
User: Urmi
Date: 11/19/2021 
Time: 10:34 AM
*/

package dynamicprog;

//GS coderpad
public class LongestRepetitiveSubString {
    public static class InputData{
        public String input;
        public int[] data = new int[2];
        public InputData(String s, int[] data) {
            input=s;
            this.data[0]=data[0];
            this.data[1]=data[1];
        }
    }
    public static void main(String[] args) {

        InputData[] input = new InputData[] {
                new InputData("abbCCCCTTTTT",  new int[]{7,5}),
                new InputData("01111112222",  new int[]{1,6}),
                new InputData("1111001",  new int[]{0,4}),
        };
        int[] data;
        for(int i=0;i<input.length;i++) {
            data=longestRepitetiveSubString(input[i].input);
            if(data[0]==input[i].data[0] && data[1]==input[i].data[1]) {
                System.out.println("Success");
            }else {
                System.out.println("Fail");

            }
        }

    }

    public static int[] longestRepitetiveSubString(String input) {
        int startOfLongest=0;
        int lengthOfLongest=0;
        int currLonggest=1;
        int currentStart=0;
        if(input.length()>0) {
            char last= input.charAt(0);
            for(int i=1;i<input.length();i++) {
                if(last==input.charAt(i)) {
                    currLonggest++;
                }else {
                    if(currLonggest>lengthOfLongest) {
                        startOfLongest=currentStart;
                        lengthOfLongest=currLonggest;
                    }
                    currentStart=i;
                    currLonggest=1;
                }
                last=input.charAt(i);
            }
            if(currentStart>startOfLongest && currLonggest>=lengthOfLongest) {
                startOfLongest=currentStart;
                lengthOfLongest=currLonggest;
            }
        }

        return new int[] {startOfLongest,lengthOfLongest};
    }

}
