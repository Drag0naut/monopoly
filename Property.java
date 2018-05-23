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
	
	public Property(int p, String n, String col, int pr, int rOrig, int rMono, int rOne, int rTwo, int rThree, int rFour, int rHotel, int hC, int mA)
	{
		position = p;
		name = n;
		owner = null;
		isMortgaged = false;
		numHouses = 0;
		color = col;
		price = pr;
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
	
	public void mortgage()
	{
		if (!isMortgaged)
		{
			isMortgaged = true;
			owner.changeMoney(MORTGAGE);
		}
	}
	public void unmortgage()
	{
		if (isMortgaged)
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
		}
	}
	public void removeHouse()
	{
		if (numHouses >= 0)
		{
			numHouses--;
			owner.changeMoney(HOUSE_COST / 2);
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
				}
				// case for n
			}
			in.close();
		}
		else if (!(p == owner) && !isMortgaged)
		{
			if (numHouses == 0) 
			{
				p.changeMoney(0 - RENT_ORIGINAL);
				owner.changeMoney(RENT_ORIGINAL);
			}
			//need case for monopoly, but no houses
			if (numHouses == 1) 
			{
				p.changeMoney(0 - RENT_ONEHOUSE);
				owner.changeMoney(RENT_ONEHOUSE);
			}
			if (numHouses == 2) 
			{
				p.changeMoney(0 - RENT_TWOHOUSE);
				owner.changeMoney(RENT_TWOHOUSE);
			}
			if (numHouses == 3) 
			{
				p.changeMoney(0 - RENT_THREEHOUSE);
				owner.changeMoney(RENT_THREEHOUSE);
			}
			if (numHouses == 4) 
			{
				p.changeMoney(0 - RENT_FOURHOUSE);
				owner.changeMoney(RENT_FOURHOUSE);
			}
			if (numHouses == 5) 
			{
				p.changeMoney(0 - RENT_HOTEL);
				owner.changeMoney(RENT_HOTEL);
			}
		}
	}
}
