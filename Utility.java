import java.util.Scanner;
public class Utility implements Space{
	private String name;
	private Player owner;
	private boolean isMortgaged;
	public static final int mortgage = 75;
	public static final int cost = 150;
	public Utility(String utilName)
	{
		name = utilName;
	}
	public String getName()
	{
		return name;
	}
	public String getColor()
	{
		return null;
	}
	public Player getOwner()
	{
		return owner;
	}
	public void act(Player p)
	{
		if (owner == null)
		{
			System.out.println("Purchase property? Yes (1) or No (2)");
			boolean found = false;
			while (!found)
			{
				Scanner in = new Scanner(System.in);
				int ans = 0;
				if (in.hasNextInt()) {ans = in.nextInt();}
				if (ans == 1)
				{
					owner = p;
					found = true;
					p.changeMoney(0 - cost);
					System.out.println(p.getName() + " has purchased " + this.getName());
				}
				else if (ans == 2)
				{
					found = true;
				}
			}
		}
		else if (!(p == owner) && !isMortgaged)
		{
			if (owner.getUtilities() == 2)
			{
				p.changeMoney(0 - p.lastRoll() * 10);
				owner.changeMoney(p.lastRoll() * 10);
			}
			else
			{
				p.changeMoney(0 - p.lastRoll() * 4);
				owner.changeMoney(p.lastRoll() * 4);
			}
}
	}
	public void mortgage()
	{
		if (!isMortgaged)
		{
			isMortgaged = true;
			owner.changeMoney(mortgage);
			System.out.println(owner.getName() + " has mortgaged " + this.getName());
		}
	}
	public void unmortgage()
	{
		if (isMortgaged)
		{
			isMortgaged = false;
			owner.changeMoney(0 - (int) (mortgage * 1.1));
			System.out.println(owner.getName() + "has unmortgaged " + this.getName());
		}
	}
	public void addHouse() {}
	public void removeHouse() {}
	public void ownerNull() {}
}