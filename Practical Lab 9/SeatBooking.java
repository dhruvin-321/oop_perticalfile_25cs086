class Booking
{
    static int seatsLeft=5;
    static  int success=0;
   synchronized void seatBooking()
    {
        if(seatsLeft>0)
        {
            seatsLeft--;
            System.out.println("ticket booked succesfully.Total seat left "+seatsLeft);
            success++;
            
        }
        else
        {
            System.out.println("no seat left...");
        }
        try{
                Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
public class SeatBooking {
    public static void main(String[] args) {
        Booking b1 = new Booking();
        Thread t1 = new Thread(()->{b1.seatBooking();});
        Thread t2 = new Thread(()->{b1.seatBooking();});
        Thread t3 = new Thread(()->{b1.seatBooking();});
        Thread t4 = new Thread(()->{b1.seatBooking();});
        Thread t5 = new Thread(()->{b1.seatBooking();});
        Thread t6 = new Thread(()->{b1.seatBooking();});
        Thread t7 = new Thread(()->{b1.seatBooking();});
        Thread t8 = new Thread(()->{b1.seatBooking();});
        Thread t9 = new Thread(()->{b1.seatBooking();});
        Thread t10 = new Thread(()->{b1.seatBooking();});
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

    }
}
