import java.util.Scanner;
import java.util.ArrayList;
public class Player {
	private String name;
	private int location;
	private int money;
	private boolean isInJail;
	private int jailTurns;
	private int railroadCount;
	private int utilitiesCount;
	private int lastRoll;
	private int numGetOutCards;
	private int houses;
	private int hotels;
	private boolean isBankrupt;
	private ArrayList<String> properties;
	boolean done = false;
	public Player(String n)
	{
		name = n;
		location = 0;
		money = 1500;
		properties = new ArrayList<String>();
	}
	public String getName()
	{
		return name;
	}
	
	public ArrayList<String> getProperties()
	{
		return properties;
	}
	public void changeMoney(int n)
	{
		money += n;
		System.out.println(this.getName() + " now has " + this.getMoney() + " dollars following a change of " + n);
	}
	public int getMoney()
	{
		return money;
	}
	public int getPos()
	{
		return location;
	}
	public void turn()
	{
		System.out.println(this.getName() + "'s turn!");
		int doubCt = 0;
		done = false;
		while (!done && !isBankrupt)
		{
			if (isInJail)
			{
				if (jailTurns == 3)
				{
					isInJail = false;
					this.changeMoney(0 - 50);
					turn();
				}
				else
				{
					System.out.println("Pay $50 fine / Use Get Out oF Jail Free Card (1) or roll for doubles (2)?");
					boolean found = false;
					while(!found)
					{
						Scanner in = new Scanner(System.in);
						int ans = in.nextInt();
						if (ans == 1)
						{
							found = true;
							isInJail = false;
							if (numGetOutCards > 0) {numGetOutCards--;}
							else {this.changeMoney(0 - 50);}
							turn();
						}
						else if (ans == 2)
						{
							found = true;
							int x = (int) (Math.random() * 6) + 1;
							int y = (int) (Math.random() * 6) + 1;
							if (x == y)
							{
								isInJail = false;
								lastRoll = x + y;
								moveTo(location + x + y);
								Board.getSpaces().get(location + x + y).act(this);
							}
							else {jailTurns++;}
						}
					}
				}
			}
			int i = (int) (Math.random() * 6) + 1;
			int j = (int) (Math.random() * 6) + 1;
			if (i == j)
			{
				doubCt++;
			}
			else
			{
				done = true;
			}
			if (doubCt == 3)
			{
				goToJail();
			}
			lastRoll = i + j;
			System.out.println(this.getName() + " has rolled a " + i + " and " + j + ", totalling " + lastRoll);
			if (location + i + j >= 40)
			{	
				int pos = (location + i + j) % 40;
				moveTo(pos);
				changeMoney(200);
				Board.getSpaces().get(pos).act(this);
			}
			else 
			{
				int pos = location + i + j;
				moveTo(pos);
				Board.getSpaces().get(pos).act(this);
			}
			while (money < 0 && !isBankrupt)
			{
				System.out.println("You are in debt! You can declare bankruptcy (1), sell houses (2), or mortgage properties (3)");
				boolean found = false;
				while (!found)
				{
					Scanner in = new Scanner(System.in);
					int rec = in.nextInt();
					if (rec == 1) 
					{
						isBankrupt = true;
						found = true;
						for (int l = 0; l < 40; l++)
						{
							if (Board.getSpaces().get(l).getOwner() != null && Board.getSpaces().get(l).getOwner().equals(this))
							{
								Board.getSpaces().get(l).ownerNull();
							}
						}
					}
					if (rec == 2)
					{
						found = true;
						System.out.println("Which property would you like to sell a house?");
						Scanner jesushelpourgame = new Scanner(System.in);
						String res = jesushelpourgame.nextLine();
						for (int k = 0; k < 40; k++)
						{
							if (Board.getSpaces().get(k).getName().equals(res))
							{
								if (Board.getSpaces().get(k).getOwner() != null && Board.getSpaces().get(k).equals(this))
								{
									Board.getSpaces().get(k).removeHouse();
								}
							}
						}
					}
					if (rec == 3)
					{
						found = true;
						System.out.println("Which property would you like to mortgage?");
						Scanner jesushelpourgame = new Scanner(System.in);
						String res = jesushelpourgame.nextLine();
						for (int k = 0; k < 40; k++)
						{
							if (Board.getSpaces().get(k).getName().equals(res))
							{
								if (Board.getSpaces().get(k).getOwner() != null && Board.getSpaces().get(k).getOwner().equals(this))
								{
									Board.getSpaces().get(k).mortgage();
								}
							}
						}
					}
				}
			}
		}
		if (isBankrupt) {System.out.println(this.getName() + " is bankrupt!");}
		else
		{
			System.out.println("Options: (1) End turn; (2) Build houses; (3) Sell houses; (4) Mortgage; (5) Unmortgage; (6) Trade");
			{
				boolean doneTurn = false;
				while (!doneTurn)
				{
					Scanner in = new Scanner(System.in);
					int end = 0;
					if (in.hasNextInt()) {end = in.nextInt();}
					if (end == 1)
					{
						doneTurn = true;
					}
					else if (end == 2)
					{
						System.out.println("Which property would you like to add a house?");
						Scanner jesushelpourgame = new Scanner(System.in);
						String res = jesushelpourgame.nextLine();
						for (int k = 0; k < 40; k++)
						{
							if (Board.getSpaces().get(k).getName().equals(res))
							{
								if (Board.getSpaces().get(k).getOwner() != null && Board.getSpaces().get(k).getOwner().equals(this))
								{
									Board.getSpaces().get(k).addHouse();
								}
							}
						}
					}
					else if (end == 3)
					{
						System.out.println("Which property would you like to sell a house?");
						Scanner jesushelpourgame = new Scanner(System.in);
						String res = jesushelpourgame.nextLine();
						for (int k = 0; k < 40; k++)
						{
							if (Board.getSpaces().get(k).getName().equals(res))
							{
								if (Board.getSpaces().get(k).getOwner() != null && Board.getSpaces().get(k).getOwner().equals(this))
								{
									Board.getSpaces().get(k).removeHouse();
								}
							}
						}
					}
					else if (end == 4)
					{
						System.out.println("Which property would you like to mortgage?");
						Scanner jesushelpourgame = new Scanner(System.in);
						String res = jesushelpourgame.nextLine();
						for (int k = 0; k < 40; k++)
						{
							if (Board.getSpaces().get(k).getName().equals(res))
							{
								if (Board.getSpaces().get(k).getOwner() != null && Board.getSpaces().get(k).getOwner().equals(this))
								{
									Board.getSpaces().get(k).mortgage();
								}
							}
						}
					}
					else if (end == 5)
					{
						System.out.println("Which property would you like to unmortgage?");
						Scanner jesushelpourgame = new Scanner(System.in);
						String res = jesushelpourgame.nextLine();
						for (int k = 0; k < 40; k++)
						{
							if (Board.getSpaces().get(k).getName().equals(res))
							{
								if (Board.getSpaces().get(k).getOwner() != null && Board.getSpaces().get(k).getOwner().equals(this))
								{
									Board.getSpaces().get(k).unmortgage();
								}
							}
						}
					}
					else if (end == 6)
					{
						System.out.println("Who would you like to trade with?");
						{
							Player dic = null;
							boolean found = false;
							while (!found)
							{
								Scanner monopolyactuallysucks = new Scanner(System.in);
								String res = monopolyactuallysucks.nextLine();
								for (Player k: Board.getPlayers())
								{
									if (k.getName().equals(res) && !(res.equals(name)))
									{
										dic = k;
										found = true;
									}
								}
							}
							trade(dic);
						}
					}
					if (end != 1)
					{
						System.out.println("Options: (1) End turn; (2) Build houses; (3) Sell houses; (4) Mortgage; (5) Unmortgage; (6) Trade");
					}
				}
			}
		}
	}
	public void moveTo(int n)
	{
		location = n;
		System.out.println(this.getName() + " moved to " + Board.getSpaces().get(location).getName());
	}
	public int roll()
	{
		int i = (int) (Math.random() * 6) + 1;
		int j = (int) (Math.random() * 6) + 1;
		return i + j;
	}
	public void goToJail()
	{
		isInJail = true;
		moveTo(10);
		System.out.println(this.getName() + " is now jailed!");
		done = true;
		jailTurns = 0;
	}
	
	public void trade(Player p) {
		//Make sure properties shown have no houses on them
		//Make sure nobody goes under $0 after trade
	}
	public boolean hasMonopoly(String color)
	{
		int colorCount = 0;
		int ownedCount = 0;
		for (int i = 0; i < 40; i++)
		{
			String propColor = Board.getSpaces().get(i).getColor();
			Player owner = Board.getSpaces().get(i).getOwner();
			if (propColor != null && propColor.equals(color))
			{
				colorCount++;
				if (owner != null && owner.equals(this))
				{
					ownedCount++;
				}
			}
		}
		if (colorCount == ownedCount)
		{
			return true;
		}
		return false;
	}
	public void drawGetOutCard() {
	    if (numGetOutCards < 2) {
	      numGetOutCards++;
	    }
	}
	public boolean getBankrupt()
	{
		return isBankrupt;
	}
	public int lastRoll() {return lastRoll;}
	public void addRailroad() {railroadCount++;}
	public void removeRailroad() {railroadCount--;}
	public int getRailroad() {return railroadCount;}
	public void addUtility() {utilitiesCount++;}
	public void removeUtility() {utilitiesCount--;}
	public int getUtilities() {return utilitiesCount;}
	public void changeHouses(int n) {houses += n;}
	public void changeHotel(int n) {hotels += n;}
	public int getHouses() {return houses;}
	public int getHotels() {return hotels;}
}
