
public class FreeParking implements Space {
	private static int money;
	public FreeParking()
	{
		money = 100;
	}
	public String getName()
	{
		return "Free Parking";
	}
	public String getColor()
	{
		return null;
	}
	public Player getOwner()
	{
		return null;
	}
	public void act(Player p)
	{
		p.changeMoney(money);
		money = 100;
	}
	public static void changeMoney(int in)
	{
		money += in;
	}
	public void addHouse() {}
	public void removeHouse() {}
	public void mortgage() {}
	public void unmortgage() {}
	public void ownerNull() {}
}
