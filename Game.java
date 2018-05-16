import java.util.ArrayList;
public class Game {
	private ArrayList<Player> playerList;
	private Board board;
	public Game() {
		playerList = new ArrayList<Player>();
		board = new Board(); //need to have static input for all properties
	}
}
