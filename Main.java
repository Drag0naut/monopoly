import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
                
                ArrayList<Player> playerList = new ArrayList<Player>();
                Board board = new Board();
                Space[] spaces = new Space[40];
                //space position starts at go = 0
                Space go = new Go(1);
                Space mediterraneanAve = new PropertySpace(1, 60, 2, 10, 30, 90, 160, 250, 50, 30);
                Space commChest1 = new CommunityChest(2);
                Space balticAve = new PropertySpace(3, 60, 4, 20, 60, 180, 320, 450, 50, 30);
                Space incomeTax = new Tax(4, 200);
                Space readingRR = new Railroad(5);
                Space orientalAve = new PropertySpace(6, 100, 6, 30, 90, 270, 400, 550, 50, 50);
                Space chance1 = new Chance(7);
                Space vermontAve = new PropertySpace(8, 100, 6, 30, 90, 270, 400, 550, 50, 50);
                Space connecticutAve = new PropertySpace(9, 120, 8, 40, 100, 300, 450, 600, 50, 60);
                Space jail = new Jail(10);
                Space stCharlesPlace = new PropertySpace(11, 140, 10, 50, 150, 450, 625, 750, 100, 70);
                Space electricCo = new Utilities(12);
                Space statesAve = new PropertySpace(13, 140, 10, 50, 150, 450, 625, 750, 100, 70);
                Space virginaAve = new PropertySpace(14, 160, 12, 60, 180, 500, 700, 900, 100, 80);
                Space pennRR = new Railroad(15);
                Space stJamesPlace = new PropertySpace(16, 180, 14, 70, 200, 550, 750, 950, 100, 90);
                Space commChest2 = new CommunityChest(17);
                Space tennesseeAve = new PropertySpace(18, 180, 14, 70, 200, 550, 750, 950, 100, 90);
                Space newYorkAve = new PropertySpace(19, 200, 16, 80, 220, 600, 800, 1000, 100, 100);
                Space freeParking = new FreeParking(20);
                Space kentuckyAve = new PropertySpace(21, 220, 18, 90, 250, 700, 875, 1050, 150, 110);
                Space chance2 = new Chance(22);
                Space indianaAve = new PropertySpace(23, 220, 18, 90, 250, 700, 875, 1050, 150, 110);
                Space illinoisAve = new PropertySpace(24, 240, 20, 100, 300, 750, 925, 1100, 150, 120);
                Space boRR = new Railroad(25);
                Space atlanticAve = new PropertySpace(26, 260, 22, 110, 330, 800, 975, 1150, 150, 130);
                Space ventnorAve = new PropertySpace(27, 260, 22, 110, 330, 800, 975, 1150, 150, 130);
                Space waterWorks = new Utilities(28);
                Space marvinGardens = new PropertySpace(29, 280, 24, 120, 360, 850, 1025, 1200, 150, 140);
                Space goToJail = new GoToJail(30);
                Space pacificAve = new PropertySpace(31, 300, 26, 130, 390, 900, 1100, 1275, 200, 150);
                Space northCarolinaAve = new PropertySpace(32, 300, 26, 130, 390, 900, 1100, 1275, 200, 150);
                Space commChest3 = new CommunityChest(33);
                Space pennsylvaniaAve = new PropertySpace(34, 320, 28, 150, 450, 1000, 1200, 1400, 200, 160);
                Space shortLine = new Railroad(35);
                Space chance3 = new Chance(36);
                Space parkPlace = new PropertySpace(37, 350, 35, 175, 500, 1100, 1300, 1500, 200, 175);
                Space luxTax = new Tax(38, 100);
                Space boardwalk = new PropertySpace(39, 400, 50, 200, 600, 1400, 1700, 2000, 200, 200);
                spaces = {
                  go, mediterraneanAve, commChest1, balticAve, incomeTax, readingRR, orientalAve, chance1, 
                  vermontAve, connecticutAve, jail, stCharlesPlace, electricCo, statesAve, virginiaAve,
                  pennRR, stJamesPlace, commChest2, tennesseeAve, newYorkAve, freeParking, kentuckyAve, 
                  chance2, indianaAve, illinoisAve, boRR, atlanticAve, ventnorAve, waterWorks, marvinGardens,
                  goToJail, pacificAve, northCarolinaAve, commChest3, pennsylvaniaAve, shortLine, parkPlace, luxTax, boardwalk
                };
                
                boolean gameOn = true;
                
                Scanner in = new Scanner(System.in);
                int numPlayers = 0;
                System.out.println("Welcome to Monopoly! How many players?");
                numPlayers = in.nextInt();
                
                for (int i = 1; i <= numPlayers; i++) {
                        System.out.println("Input Player " + i + "\'s name:");
                        playerList.add(new Player(in.nextLine()));
                }
                
                System.out.println("Each of you starts with $1500. Let's play!");
                
                while (gameOn) {
                        for (Player player : playerList) {
                                if (!player.isInJail()) {
                                        player.move(); // move returns an int now
                                }
                        }
                }
                
        }
}
