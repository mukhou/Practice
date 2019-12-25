package threads;

public class TicketBooking implements Runnable {
    int ticketsAvailable=1;

    @Override
    public void run() {
        System.out.println("Waiting to book ticket for : "+Thread.currentThread().getName());
        synchronized (this){
            if(ticketsAvailable > 0){
                System.out.println("Booking ticket for : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticketsAvailable --;
                System.out.println("Ticket BOOKED for : "+ Thread.currentThread().getName());
                System.out.println("currently ticketsAvailable = "+ticketsAvailable);
            }else {
                System.out.println("Ticket NOT BOOKED for : "+ Thread.currentThread().getName());
            }
        }


    }
}
