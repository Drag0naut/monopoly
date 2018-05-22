import java.util.Scanner;
public class Utilities implements Space{
	private int position;
	private Player owner;
	private boolean isMortgaged;
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
					owner = p;
					found = true;
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
}
