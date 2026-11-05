import java.util.*;
class VendingMachine
{
   enum Coin{ONE,TWO,FIVE,TEN}
   public static void main(String []a)
   {
	Coin c = null;
	int value = 0;
	final int PRICE = 15;
	int total = 0;
	Scanner sc = new Scanner(System.in);
	while(total<=PRICE)
	{
	   System.out.println("enter coins");
	   String input = sc.nextLine();
	   try
	   {
		c =Coin.valueOf(input.toUpperCase());
	   }
	   catch(Exception e)
	   {
		System.out.println("not a valid coin...enter again");
		continue;
	   }
	   switch(c)
	   {
		case ONE: value = 1;break;
		case TWO: value = 2;break;
		case FIVE: value = 5;break;
		case TEN: value = 10;break;
	   }
	   total= total + value;
	   System.out.println("total=" + total);
	}
	System.out.println("total paid=" + total + "and diff=" + (total-PRICE));
    }
}	
		
	   