import java.util.Scanner;
public class Utilities implements Space {
	private int position;
	private Player owner;
	private boolean isMortgaged;
	public static final int MORTGAGE = 75;
	public static final int COST = 150;
	public Utilities(int pos)
	{
		position = pos;
		isMortgaged = false;
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
					found = true;
					owner = p;
					owner.changeMoney(0 - COST);
					owner.addUtility();
				}
				// case for n
			}
			in.close();
		}
		else if (!(p == owner) && !isMortgaged)
		{
			if (owner.getUtilities() == 2)
			{
				p.changeMoney(0 - p.prevRoll() * 10);
				owner.changeMoney(p.prevRoll() * 10);
			}
			else
			{
				p.changeMoney(0 - p.prevRoll() * 4);
				owner.changeMoney(p.prevRoll() * 4);
			}
		}	
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
}
