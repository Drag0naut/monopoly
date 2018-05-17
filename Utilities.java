
public class Utilities implements Space {
	private String name;
	private Player owner;
	private boolean mortgageState;
	private static final int COST;
	private static final int MORTGAGE;
	private static final int UNMORTGAGE;
	private static final int RENT_MULTIPLIER;
	
	public Utilities(String namein, int cost, int mortgage, int unmortgage, int multiplier)
	{
		name = namein;
		COST = cost;
		MORTGAGE = mortgage;
		UNMORTGAGE = unmortgage;
		RENT_MULTIPLIER = multiplier;
		mortgageState = true;
	}
	public void setOwner(String own)
	{
		owner = own;
	}
	public void changeMortgageState()
	{
		mortgageState  = !mortgageState;
		// how to give back or take money tho?	
	}
	public void act(Player p)
	{
		if (owner == null)
		{
			p.askBuy(); //ask the user if they want to buy the property
		}
		else
		{
			int transfer = (p.roll1() + p.roll2()) * RENT_MULTIPLIER;
			p.getMoney(transfer); // removes money from player
			owner.addMoney(transfer);
		}
	}
	
}
