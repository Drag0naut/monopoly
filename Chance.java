import java.util.ArrayList;
public class Chance implements Space{
	public Chance()
	{
		
	}
	public String getName()
	{
		return "Chance";
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
		int ran = (int) (Math.random() * 16);
		if (ran == 0)
        {
			System.out.println("Chance Card: Advance to Go!");
            p.moveTo(0);
            Board.getSpaces().get(0).act(p);
        }
        if (ran == 1)
        {
        	System.out.println("Chance Card: Advance to Illinois Ave.");
            p.moveTo(24);
            Board.getSpaces().get(24).act(p);
        }
        if (ran == 2)
        {
        	System.out.println("Chance Card: Advance to St. Charles Place.");
            p.moveTo(11); 
            Board.getSpaces().get(11).act(p);
        }
        if (ran == 3)
        {
        	System.out.println("Chance Card: Advance to the nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.");
            if (p.getPos() < 12 || p.getPos() > 28)
            {
            	p.moveTo(12);
            	if (Board.getSpaces().get(12).getOwner() != null && Board.getSpaces().get(12).getOwner() != p)
            	{
            		int i = p.roll();
            		p.changeMoney(0 - i * 10);
            		Board.getSpaces().get(12).getOwner().changeMoney(i * 10);
            	}
            }
            else
            {
            	p.moveTo(28);
            	if (Board.getSpaces().get(28).getOwner() != null && Board.getSpaces().get(28).getOwner() != p)
            	{
            		int i = p.roll();
            		p.changeMoney(0 - i * 10);
            		Board.getSpaces().get(28).getOwner().changeMoney(i * 10);
            	}
            }
            	// go to  closest utility,  if owned, pay ten  times dice roll
        }
        if (ran == 4)
        {
        	System.out.println("Chance Card: Advance to the nearest Railroad and pay the owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.");
            if (p.getPos() < 5) 
            {
            	p.moveTo(5);
            	Board.getSpaces().get(5).act(p);
            	Board.getSpaces().get(5).act(p);
            }
            else if (p.getPos() < 15) 
            {
            	p.moveTo(15);
            	Board.getSpaces().get(15).act(p);
            	Board.getSpaces().get(15).act(p);
            }
            else if (p.getPos() < 25)
            {
            	p.moveTo(25);
            	Board.getSpaces().get(25).act(p);
            	Board.getSpaces().get(25).act(p);
            }
            else if (p.getPos() < 35) 
            {
            	p.moveTo(35);
            	Board.getSpaces().get(35).act(p);
            	Board.getSpaces().get(35).act(p);
            }
            else 
            {
            	p.moveTo(5);
            	Board.getSpaces().get(5).act(p);
            	Board.getSpaces().get(5).act(p);
            }
        }
        if (ran == 5)
        {
        	System.out.println("Chance Card: Bank pays you dividend of $50.");
            p.changeMoney(50);
        }
        if (ran == 6)
        {
        	System.out.println("Chance Card: Get Out Of Jail Free -- This card may be kept until needed.");
            p.drawGetOutCard();
        }
        if (ran == 7)
        {
        	System.out.println("Chance Card: Go Back 3 Spaces");
            p.moveTo(p.getPos() - 3);
        }
        if (ran == 8)
        {
        	System.out.println("Chance Card: Go To Jail -- Go Directly To Jail -- Do not pass Go, do not collect $200.");
            p.goToJail();
        }
        if (ran == 9)
        {
        	System.out.println("Chance Card: Make general repairs on all your property -- For each house pay $25 -- For each hotel pay $100.");
        	int i = 0;
        	i += p.getHouses() * 25;
        	i += p.getHotels() * 100;
            p.changeMoney(0-i);
        }
        if (ran == 10)
        {
        	System.out.println("Chance Card: Pay poor tax of $15.");
            p.changeMoney(0-15);
        }
        if (ran == 11)
        {
        	System.out.println("Chance Card: Take a trip to Reading Railroad -- If you pass Go, collect $200.");
        	if (p.getPos() > 5) {p.changeMoney(200);}
            p.moveTo(5);
        }
        if (ran == 12)
        {
        	System.out.println("Chance Card: Advance to Boardwalk.");
            p.moveTo(39);
        }
        if (ran == 13)
        {
        	System.out.println("Chance Card: You have been elected Chairman of the Board -- Pay each $50");
            p.changeMoney(0-150);
            ArrayList<Player> temp = Board.getPlayers();
            for (int i = 0; i < temp.size(); i++)
            {
            	if (!(temp.get(i).equals(p))) {temp.get(i).changeMoney(50);}
            }
        }
        if (ran == 14)
        {
        	System.out.println("Chance Card: Your building and loan matures -- Collect $150.");
            p.changeMoney(150);
        }
        if (ran == 15)
        {
        	System.out.println("Chance Card: You have won a crossword competition -- Collect $100.");
            p.changeMoney(100);
        }
	}
	public void addHouse() {}
	public void removeHouse() {}
	public void mortgage() {}
	public void unmortgage() {}
	public void ownerNull() {}
}
