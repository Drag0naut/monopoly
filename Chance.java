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
            p.moveTo(0);
            Board.getSpaces().get(0).act(p);// go to  go space
        }
        if (ran == 1)
        {
            p.moveTo(24);
            Board.getSpaces().get(24).act(p);//x = illinoisave, go to  Illinois Ave.
        }
        if (ran == 2)
        {
            p.moveTo(11); // x = stcharlesplace, go to st charles place
            Board.getSpaces().get(11).act(p);
        }
        if (ran == 3)
        {
            if (p.getPos() < 12 || p.getPos() > 28) // x = pos of first util, y = pos of last util
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
            if (p.getPos() < 5) {p.moveTo(5); p.moveTo(5);}
            else if (p.getPos() < 15) {p.moveTo(15); p.moveTo(15);}
            else if (p.getPos() < 25) {p.moveTo(25); p.moveTo(25);}
            else if (p.getPos() < 25) {p.moveTo(35); p.moveTo(35);}
            else {p.moveTo(5); p.moveTo(5);}
        }
        if (ran == 5)
        {
            p.changeMoney(50);//give 50 bucks to  player
        }
        if (ran == 6)
        {
            p.drawGetOutCard();//get out of jail  free card
        }
        if (ran == 7)
        {
            p.moveTo(p.getPos() - 3);// go back  3 spaces
        }
        if (ran == 8)
        {
            p.goToJail();// go  to jail
        }
        if (ran == 9)
        {
        	int i = 0;
        	i += p.getHouses() * 25;
        	i += p.getHotels() * 100;
            p.changeMoney(0-i); //25 bucks foreach house, 100 for each hotel owned
        }
        if (ran == 10)
        {
            p.changeMoney(0-15);// 15 $ tax
        }
        if (ran == 11)
        {
        	if (p.getPos() > 5) {p.changeMoney(200);}
            p.moveTo(5); //go to reading railroad, if pass go,  collect 200
        }
        
        if (ran == 12)
        {
            p.moveTo(39); // go  to  boardwalk
        }
        if (ran == 13)
        {
            p.changeMoney(0-150);
            ArrayList<Player> temp = Board.getPlayers();
            for (int i = 0; i < temp.size(); i++)
            {
            	if (!(temp.get(i).equals(p))) {temp.get(i).changeMoney(50);}
            }
            //pay each player $50, check if this works perfectly tho
        }
        if (ran == 14)
        {
            p.changeMoney(150); //collect $150
        }
        if (ran == 15)
        {
            p.changeMoney(100);//collect $100
}
	}
}
