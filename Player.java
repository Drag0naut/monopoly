import java.util.Scanner;
public class Player {

  private String name;
  private int location;
  private int money;
  private int numHouses;
  private int numHotels;
  private boolean isInJail;
  private boolean pastDouble;
  private int jailTurns;
  private int numGetOutCards;
  private boolean isTurn;
  private int doublesCount;
  private int railroadCount;
  private int pastRoll;
  private int utilitiesCount;
  
  public Player(String n) {
    name = n;
    location = 0;
    money = 1500;
    numHouses = 0;
    isInJail = false;
    jailTurns = 0;
    numGetOutCards = 0;
    isTurn = false;
  }
  
  public String getName() {
    return name;
  }
  
  public int getMoney() {
    return money;
  }
	
  public int getHouses() {
  	return numHouses;
  }
        
  public int getHotels() 
  {
      return numHotels;
  }
  
  public void changeMoney(int amt) {
    money += amt;
  }
  
  public void goToJail() {
    isInJail = true;
    goTo(10);
    jailTurns = 0;
  }
	
  public boolean isInJail() {
	 return isInJail;
  }
  
  public void drawGetOutCard() {
    if (numGetOutCards < 2) {
      numGetOutCards++;
    }
  }
  
  public int getPos()
  {
	  return location;
  }
  
  public void goTo(int n)
  {
	  location = n;
	  spaces[location].act(this);
  }
  
  public int getRoll()
  {
	  int i = (int) Math.random() * 6;
	  int j = (int) Math.random() * 6;
	  System.out.println("Rolled a " + i + " and a " + j);
	  if (i == j) 
	  {
		  doublesCount++;
		  pastDouble = true;
	  }
	  else {pastDouble = false;}
	  pastRoll = i+j;
	  return pastRoll;
  }
  public int prevRoll()
  {
	  return pastRoll;
  }
  public void move() {
	  if (isInJail)
	  {
		  if (jailTurns == 3)
		  {
			  isInJail = false;
			  this.changeMoney(0 - 50);
			  move();
		  }
		  else
		  {
			  Scanner in = new Scanner(System.in);
			  System.out.println("Pay $50 fine (1) or roll for doubles (2)?");
			  String ans = in.next();
			  boolean found = false;
			  while (!found)
			  {
				  if (ans.equals("1"))
				  {
					  found = true;
					  isInJail = false;
					  this.changeMoney(0 - 50);
					  move();
				  }
				  else if (ans.equals("2"))
				  {
					  found = true;
					  int roll = getRoll();
					  if (pastDouble == true)
					  {
						  isInJail = false;
						  goTo(10 + roll);
					  }
					  else {jailTurns++;}
				  }
			  }
			  in.close();
		  }
	  }
	  
	  int r = getRoll();
	  if (doublesCount == 3) {goToJail();}
	  else if (location + r >= 40)
	  {
		  goTo((location + r) % 40);
		  changeMoney(200);
	  }
	  else
	  {
		  goTo(location + r);
	  }
	  if (pastDouble == true) {move();}
  }
  
  public void changeTurn() { //need to trigger this when ending turn.
    isTurn = !isTurn;
    doublesCount = 0;
  }
  
  public void addRailroad() {railroadCount++;}
  public void removeRailroad() {railroadCount--;}
  public int getRailroad() {return railroadCount;}
  public void addUtility() {utilitiesCount++;}
  public void removeUtility() {utilitiesCount--;}
  public int getUtilities() {return utilitiesCount;}
  
}
