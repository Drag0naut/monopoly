
public class GoToJail implements Space {
	public GoToJail()
	{
		
	}
	public String getName()
	{
		return "Go To Jail";
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
		p.goToJail();
	}
}
