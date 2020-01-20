/* 
User: Urmi
Date: 1/18/2020 
Time: 5:45 PM
*/

package conceptual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IncorrectFileNameException extends Exception {

    public IncorrectFileNameException(String msg, Throwable t){
        super(msg, t);
    }

    public static void main(String[] args) throws IncorrectFileNameException {
        String fileName = "fileName";
        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                System.out.println(file.nextLine());
            }
        } catch (FileNotFoundException err) {
            if (!isCorrectFileName(fileName)) {
                throw new IncorrectFileNameException(
                        "Incorrect filename provided: " + fileName , err);
            }
            // ...
        }
    }
    private static boolean isCorrectFileName(String name){
        return false;
    }
}
