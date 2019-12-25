package threads;

public class TestTicketBooking {
    public static void main(String args[])
    {
        TicketBooking obj=new TicketBooking();

        Thread thread1=new Thread(obj,"Passenger1 Thread");
        Thread thread2=new Thread(obj,"Passenger2 Thread");

        thread1.start();
        thread2.start();

    }
}
