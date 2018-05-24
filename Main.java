import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Player> playerList = new ArrayList<Player>();
        Scanner in = new Scanner(System.in);
        int numPlayers = 0;
        System.out.println("Welcome to Monopoly! How many players?");
        numPlayers = in.nextInt();
        for (int i = 1; i <= numPlayers; i++) {
             System.out.println("Input Player " + i + "\'s name:");
             String temp = in.next();
             playerList.add(new Player(temp));
        }
        in.close();
        ArrayList<Space> spaces = new ArrayList<Space>();
        spaces.add(new Go());
        spaces.add(new Property("Mediterranean Avenue", "Brown", 60, 2, 4, 10, 30, 90, 160, 250, 50, 30));
        spaces.add(new CommunityChest());
        spaces.add(new Property("Baltic Avenue", "Brown", 60, 4, 8, 20, 60, 180, 320, 450, 50, 30));
        spaces.add(new Tax("Income Tax", 200));
        spaces.add(new Railroad("Reading Railroad"));
        spaces.add(new Property("Oriental Avenue", "Light Blue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50));
        spaces.add(new Chance());
        spaces.add(new Property("Vermont Avenue", "Light BLue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50));
        spaces.add(new Property("Connecticut Avenue", "Light Blue", 120, 8, 16, 40, 100, 300, 450, 600, 50, 60));
        //add more spaces
        Board board = new Board(spaces, playerList);
        System.out.println("Each of you starts with $1500. Let's play!");
        for (int i = 0; i < 35; i++)
        {
        	for (Player p: playerList)
        	{
        		p.turn();
        	}
        }
	}
}
