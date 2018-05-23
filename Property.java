import java.util.Scanner;
public class Property implements Space{
	private int position;
	private String name;
	private Player owner;
	private boolean isMortgaged;
	private int numHouses;
	private final String color;
	private final int price;
	private final int RENT_ORIGINAL;
	private final int RENT_MONOPOLY;
	private final int RENT_ONEHOUSE;
	private final int RENT_TWOHOUSE;
	private final int RENT_THREEHOUSE;
	private final int RENT_FOURHOUSE;
	private final int RENT_HOTEL;
	private final int HOUSE_COST;
	private final int MORTGAGE;
        private int rent;

	
	public Property(int p, String n, String col, int pr, int rOrig, int rMono, int rOne, int rTwo, int rThree, int rFour, int rHotel, int hC, int mA)
	{
		position = p;
		name = n;
		owner = null;
		isMortgaged = false;
		numHouses = 0;
		color = col;
		price = pr;
                rent = rOrig;
		RENT_ORIGINAL = rOrig;
		RENT_MONOPOLY = rMono;
		RENT_ONEHOUSE = rOne;
		RENT_TWOHOUSE = rTwo;
		RENT_THREEHOUSE = rThree;
		RENT_FOURHOUSE = rFour;
		RENT_HOTEL = rHotel;
		HOUSE_COST = hC;
		MORTGAGE = mA;
	}
	
	public void changeMortgage()
	{
		if (!isMortgaged)
		{
			isMortgaged = true;
			owner.changeMoney(MORTGAGE);
		}
		else
		{
			isMortgaged = false;
			owner.changeMoney(0 - (int) (MORTGAGE * 1.1));
		}
	}
	
	public void addHouse()
	{
		if (numHouses < 5)
		{
			numHouses++;
			owner.changeMoney(0 - HOUSE_COST);
		        if (numHouses == 1) 
			{
				rent = RENT_ONEHOUSE;
			}
			else if (numHouses == 2) 
			{
				rent = RENT_TWOHOUSE;
			}
			else if (numHouses == 3) 
			{
				rent = RENT_THREEHOUSE;
			}
			else if (numHouses == 4) 
			{
				rent = RENT_FOURHOUSE;
			}
			else if (numHouses == 5) 
			{
				rent = RENT_HOTEL;
			}
		} else {
                        System.out.println("Maximum houses owned on this property. Cannot add another.");
                }
		
	}
	public void removeHouse()
	{
		if (numHouses >= 0)
		{
			numHouses--;
			owner.changeMoney(HOUSE_COST / 2);
                        if (numHouses == 0) 
			{
				rent = RENT_ORIGINAL;
			}
                        else if (numHouses == 1) 
			{
				rent = RENT_ONEHOUSE;
			}
			else if (numHouses == 2) 
			{
				rent = RENT_TWOHOUSE;
			}
			else if (numHouses == 3) 
			{
				rent = RENT_THREEHOUSE;
			}
			else if (numHouses == 4) 
			{
				rent = RENT_FOURHOUSE;
			}
		} else {
                        System.out.println("No houses owned on this property. Cannot remove another.");
		}
	}
	public void act(Player p)
	{
		if (owner == null)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Purchase property? y/n");
			String ans = in.next();
			boolean found = false;
			while (!found)
			{
				if (ans.equals("y"))
				{
					owner = p;
					found = true;
					p.changeMoney(0 - price);
				}
				// case for n
			}
			in.close();
		}
		else if (!(p == owner) && !isMortgaged)
		{
			p.changeMoney(0 - rent);
			owner.changeMoney(rent);
			}
			//need case for monopoly, but no houses
		}
	}
}
