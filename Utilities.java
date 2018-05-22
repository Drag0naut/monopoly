
public class Utilities implements Space{
	public void act(Player p)
	{
		if (this.getOwner().getUtilities() == 2)
		{
			p.changeMoney(0 - p.getRoll() * 10);
			this.getOwner().changeMoney(p.getRoll() * 10);
		}
		else
		{
			p.changeMoney(0 - p.getRoll() * 4);
			this.getOwner().changeMoney(p.getRoll() * 4);
		}
	}
}
