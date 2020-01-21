package threads;

public class TestTicketBooking {
    public static void main(String args[]){

        TicketBooking runnableObj = new TicketBooking();

        Thread thread1 = new Thread(runnableObj,"Passenger1 Thread");
        Thread thread2 = new Thread(runnableObj,"Passenger2 Thread");
        thread1.start();
        thread2.start();
    }
}
