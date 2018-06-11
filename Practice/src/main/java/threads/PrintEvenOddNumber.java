package threads;

public class PrintEvenOddNumber extends Thread{
	
	int maxNumber = 100;
    int number = 1;
    public void PrintEven()
    {
        while (number < maxNumber)
        {
            if (number % 2 == 0)
            {
               // Console.WriteLine(number);
            	System.out.println(Thread.currentThread().getName() + " " + number + " ");
                number++;
            }
        }
    }
    public void PrintOdd()
    {
        while (number < maxNumber)
        {
            if (number % 2 != 0)
            {
             //   Console.WriteLine(number);
                System.out.println(Thread.currentThread().getName() + " " + number + " ");
                number++;
            }
        }
    }


	public static void main(String[] args) {
		Thread evenThread = new Thread();
		evenThread.start();
		evenThread.setName("EvenThread");        
        Thread oddThread = new Thread();
        oddThread.setName("Odd Thread");
        oddThread.start();

        

	}

}
