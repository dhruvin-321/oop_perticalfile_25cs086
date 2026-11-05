class Thermostat
{
	
	private String location;
	private int temp;
	private static final int MIN = 16;
	private static final int MAX = 30;
	private static int activeCount = 0;

	Thermostat(String location,int startTemp)
	{
	   this.location =location;
	   if(startTemp > MAX || startTemp < MIN)
	   {
		temp = 22;
	   }
	   else
	   {
	 	temp = startTemp;
	   }
	   activeCount++;
	}
	Thermostat(String location)
	{
	   this(location,22);
	}
	public void raise()
	{
	   if(temp<MAX)
		temp++;
	   else
	     System.out.println("Already at maximum (30)");
	}
	public void lower()
	{
	   if(temp>MIN)
		temp--;
	   else
	     System.out.println("Already at minimum (16)");
	}
	public int getTemperature()
	{
	   return temp;
	}
	public static int getActiveCount()
	{
	  return activeCount;
	}
	public static void main(String[] a)
	{
	   Thermostat t1 = new Thermostat("Nadiad",35);
	   Thermostat t2 = new Thermostat("Ahmedabad");
	   for(int i=1;i<=10;i++)
	   {
		t1.raise();
		System.out.println(t1.getTemperature());
	   }
	   for(int i=1;i<=20;i++)
	   {
		t1.lower();
		System.out.println(t1.getTemperature());
	   }
	   System.out.println(Thermostat.getActiveCount());
	}
	
}