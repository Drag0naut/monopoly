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
	public Player(String n)
	{
		name = n;
		location = 0;
		money = 1500;
	}
	public String getName()
	{
		return name;
	}
	public void changeMoney(int n)
	{
		money += n;
		System.out.println(this.getName() + " had his money changed by " + n);
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
		int doubCt = 0;
		boolean done = false;
		while (!done)
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
					Scanner in = new Scanner(System.in);
					System.out.println("Pay $50 fine / Use Get Out oF Jail Free Card (1) or roll for doubles (2)?");
					String ans = in.next();
					boolean found = false;
					while(!found)
					{
						if (ans.equals("1"))
						{
							found = true;
							isInJail = false;
							if (numGetOutCards > 0) {numGetOutCards--;}
							else {this.changeMoney(0 - 50);}
							turn();
						}
						else if (ans.equals("2"))
						{
							found = true;
							int x = (int) Math.random() * 6 + 1;
							int y = (int) Math.random() * 6 + 1;
							if (x == y)
							{
								isInJail = false;
								lastRoll = x + y;
								moveTo(location + x + y);
								Board.getSpaces().get(location + x + y).act(this);
							}
							else {jailTurns++;}
						}
						in.close();
					}
				}
			}
			if (doubCt == 3)
			{
				goToJail();
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
			lastRoll = i + j;
			System.out.println(this.getName() + " has rolled a " + lastRoll);
			if (location + i + j >= 40)
			{	
				int pos = (location + i + j) % 40;
				moveTo(pos);
				Board.getSpaces().get(pos).act(this);
				changeMoney(200);
			}
			else 
			{
				int pos = location + i + j;
				moveTo(pos);
				Board.getSpaces().get(pos).act(this);
			}
		}
		
	}
	public void moveTo(int n)
	{
		location = n;
		System.out.println(this.getName() + " has moved to " + Board.getSpaces().get(location).getName());
	}
	public int roll()
	{
		int i = (int) Math.random() * 6 + 1;
		int j = (int) Math.random() * 6 + 1;
		return i + j;
	}
	public void goToJail()
	{
		isInJail = true;
		moveTo(10);
		jailTurns = 0;
	}
	public boolean hasMonopoly(String color)
	{
		ArrayList<Space> spaces = Board.getSpaces();
		int colorCount = 0;
		int ownedCount = 0;
		for (int i = 0; i < spaces.size(); i++)
		{
			if (spaces.get(i).getColor().equals(color))
			{
				colorCount++;
				if (spaces.get(i).getOwner().equals(this))
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
