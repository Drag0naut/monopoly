import java.util.ArrayList;
public class Board {
	
	private Space[] spaces;
	private ChanceCard chance;
	private CommunityChestCard chest;
	
	public Board(Space[] s) {
		spaces = new Space[40];
		for (int i = 0; i < s.length; i++) {
			spaces[i] = s[i];
		}
	}
}
