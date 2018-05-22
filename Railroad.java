import java.util.Scanner;
public class Railroad implements Space {
  
  private int position;
  private String name;
  private Player owner;
  private boolean isMortgaged;
  private static int numOwned;
  private int price;
  private int rent;
  private int mortgageCost;
  
  public Railroad(int p, String n) {
    position = p;
    name = n;
    owner = null;
    isMortgaged = false;
    numOwned = 0;
    price = 200;
    rent = 25;
    mortgageCost = 100;
  }
  
  public void act(Player p) {
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
					p.addRailroad();
				}
				// case for n
			}
			in.close();
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
  
  public String getName() {
    return name;
  }
  
  public int getPrice() {
    return price;
  }
  
  public int getRent() {
    return rent;
  }
  
  public int getMortgageCost() {
    return mortgageCost;
  }

}
