
public class Tax implements Space {
	private String name;
	private int tax;
	public Tax(String taxName, int taxPrice)
	{
		name = taxName;
		tax = taxPrice;
	}
	public String getName()
	{
		return name;
	}
	public void act(Player p)
	{
		p.changeMoney(0 - tax);
		FreeParking.changeMoney(tax);
	}
	public String getColor()
	{
		return null;
	}
	public Player getOwner()
	{
		return null;
	}
}
