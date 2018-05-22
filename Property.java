import java.util.Scanner;
public class Property implements Space{
	private int position;
	private String name;
	private Player owner;
	private boolean isMortgaged;
	private int numHouses;
	private String color;
	private int price;
	private final int RENT_ORIGINAL;
	private final int RENT_MONOPOLY;
	private final int RENT_ONEHOUSE;
	private final int RENT_TWOHOUSE;
	private final int RENT_THREEHOUSE;
	private final int RENT_FOURHOUSE;
	private final int RENT_HOTEL;
	private int houseCost;
	private int houseCount;
	private int mortgageAmt;
	
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
		houseCost = hC;
		mortgageAmt = mA;
	}
	public void setOwner()
	{

	}
	public void changeMortgageState()
	{
		if (isMortgaged) {
			isMortgaged = false;
		}
		else {
			isMortgaged = true;
		}
	}
	public void addHouses()
	{
		numHouses++;
	}
	public void removeHouses()
	{
		numHouses--;
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
			if (houseCount == 0) 
			{
				p.changeMoney(0 - RENT_ORIGINAL);
				owner.changeMoney(RENT_ORIGINAL);
			}
			//need case for monopoly, but no houses
			if (houseCount == 1) 
			{
				p.changeMoney(0 - RENT_ONEHOUSE);
				owner.changeMoney(RENT_ONEHOUSE);
			}
			if (houseCount == 2) 
			{
				p.changeMoney(0 - RENT_TWOHOUSE);
				owner.changeMoney(RENT_TWOHOUSE);
			}
			if (houseCount == 3) 
			{
				p.changeMoney(0 - RENT_THREEHOUSE);
				owner.changeMoney(RENT_THREEHOUSE);
			}
			if (houseCount == 4) 
			{
				p.changeMoney(0 - RENT_FOURHOUSE);
				owner.changeMoney(RENT_FOURHOUSE);
			}
			if (houseCount == 5) 
			{
				p.changeMoney(0 - RENT_HOTEL);
				owner.changeMoney(RENT_HOTEL);
			}
		}
	}
}
