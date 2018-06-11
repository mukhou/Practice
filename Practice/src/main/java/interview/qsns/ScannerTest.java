package interview.qsns;

import java.util.Scanner;

public class ScannerTest
{

  public static void main (String[] args)
  {
    //  prompt the user to enter their name
    System.out.print("Enter your name: ");

    // get their input
    Scanner scanner = new Scanner(System.in);

    // there are several ways to get the input, this is 
    // just one approach
    String username = scanner.nextLine();

    // test the String
    if (username.trim().equals(""))
    {
      System.out.println("Hmm, I didn't get your name");
    }
    else
    {
      System.out.println("Thanks for the name, " + username);
    }
  }

}