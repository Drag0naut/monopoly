import java.util.Scanner;
public class Railroad implements Space {
	private String name;
	private Player owner;
	private boolean isMortgaged;
	private static final int mortgage = 100;
	private static final int cost = 200;
	public Railroad(String railName)
	{
		name = railName;
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
					p.getProperties().add(this.getName());
					found = true;
					System.out.println(p.getName() + " has purchased " + this.getName());
					p.changeMoney(0 - cost);				
				}
				else if (ans == 2)
				{
					found = true;
				}
			}
		}
	 else if (!(p == owner) && !isMortgaged)
	 {
		 if (owner.getRailroad() == 1)
		 {
			 p.changeMoney(0-25);
			 owner.changeMoney(25);
		 }
		 else if (owner.getRailroad() == 2)
		 {
			 p.changeMoney(0-50);
			 owner.changeMoney(50);
		 }
		 else if (owner.getRailroad() == 3)
		 {
			 p.changeMoney(0-100);
			 owner.changeMoney(100);
		 }
		 else 
		 {
			 p.changeMoney(0-200);
			 owner.changeMoney(200);
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
			  System.out.println(owner.getName() + " has unmortgaged " + this.getName());
		  }
	  }
	  public void addHouse() {}
	  public void removeHouse() {}
	  public void ownerNull() {}
}
