/* 
User: Urmi
Date: 1/8/2020 
Time: 6:32 PM
*/

package arraysandstrings;

//https://www.geeksforgeeks.org/remove-spaces-from-a-given-string/
public class RemoveSpaceFromString {

    static int removeSpaces(char[] arr){
        // To keep track of non-space character count
        int count = 0;
        // Traverse the given string.
        // If current character is not space, then place it at index 'count++'
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != ' '){
                arr[count ++] = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        char str[] = "g eeks for ge eeks ".toCharArray();
        int i = removeSpaces(str);
        System.out.println(String.valueOf(str).substring(0, i));
    }

}
