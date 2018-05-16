
public class Property implements Square{
	private String name;
	private String owner;
	private boolean isMortgaged;
	private int numHouses;
	private String color;
	private static final int RENT;
	private static final int RENT_MONOPOLY;
	private static final int RENT_ONEHOUSE;
	private static final int RENT_TWOHOUSE;
	private static final int RENT_THREEHOUSE;
	private static final int RENT_FOURHOUSE;
	private static final int RENT_HOTEL;
	public Property(String n, String c, ...//rents)
	{
		name = n;
		owner = "";
		isMortgaged = false;
		numHouses = 0;
		color = c;
		...//rents
	}
	public void setOwner()
	{

	}
	public void changeMortgageState()
	{
		
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
		}
	}
}
