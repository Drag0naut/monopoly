
public interface Space {
	void act(Player p);
	String getColor();
	Player getOwner();
	String getName();
	void addHouse();
	void removeHouse();
	void mortgage();
	void unmortgage();
}
