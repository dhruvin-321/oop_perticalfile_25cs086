class CinemaShow 
{
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked;
    CinemaShow(String title,int capacity)
    {
	this.title = title;
	this.capacity = capacity;
	seatsAvailable = capacity;
    }
    CinemaShow(String title)
    {
	this(title,100);
    }
    public boolean book(int n)
    {
	if( n <= seatsAvailable)
	{
	   	seatsAvailable=seatsAvailable-n;
	   	totalBooked = totalBooked +n;
		System.out.println("Congratulations ... You have booked "+ n + "Seats ");
	   	return true;
	}
	else
  	  {
		System.out.println("Sorry... "+ n + "Seats not available");
		return false;
		}
    }

    public int getSeatsAvailable()
	{
		return seatsAvailable;
	}

	public static int getTotalBooked()
	{
		return totalBooked;
	}   	 
	
	public static void main(String []a)
	{
		CinemaShow c1 = new CinemaShow("Alpha",200);
		CinemaShow c2 = new CinemaShow("OnePiece");
		System.out.println("Seats Available = "+c1.getSeatsAvailable());

		c1.book(25);

		System.out.println("Seats Available = "+c1.getSeatsAvailable());

		c2.book(101);
		c2.book(25);
		
		System.out.println("Total Seats Booked = "+CinemaShow.getTotalBooked());

	}
}