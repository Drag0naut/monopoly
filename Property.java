
public class Property implements Square{
	private String name;
	private String owner;
	private boolean isMortgaged;
	private int numHouses;
	private String color;
	private int rent;
	private final int RENT_ORIGINAL;
	private final int RENT_MONOPOLY;
	private final int RENT_ONEHOUSE;
	private final int RENT_TWOHOUSE;
	private final int RENT_THREEHOUSE;
	private final int RENT_FOURHOUSE;
	private final int RENT_HOTEL;
	public Property(String n, String col, int rOrig, int rMono, int rOne, int rTwo, int rThree, int rFour, int rHotel)
	{
		name = n;
		owner = "";
		isMortgaged = false;
		numHouses = 0;
		color = c;
		rent = rOrig;
		RENT_ORIGINAL = rOrig;
		RENT_MONOPOLY = rMono;
		RENT_ONEHOUSE = rOne;
		RENT_TWOHOUSE = rTwo;
		RENT_THREEHOUSE = rThree;
		RENT_FOURHOUSE = rFour;
		RENT_HOTEL = rHotel;	
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
		if (owner.equals("")) {
			Scanner in = new Scanner(System.in);
			System.out.println("Purchase property? y/n");
			String ans = in.next();
			if (ans.equals("y")) {
			owner = p.getName();
			}
		} else if (!p.getName().equals(owner)) {
			... //add cases that determine rent amt
			p.changeMoney(0 - RENT);
			
			//need else if mortgaged 
	}
}
