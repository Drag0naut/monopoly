public class Player {

  private String name;
  private int location;
  private int money;
  private int numHouses;
  private int numHotels;
  private boolean isInJail;
  private int jailTurns;
  private int numGetOutCards;
  private int position;
  private boolean isTurn;
  private int doublesCount;
  private int railroadCount;
  private int pastRoll;
  
  public Player(String n) {
    name = n;
    location = 0;
    money = 1500;
    numHouses = 0;
    isInJail = false;
    jailTurns = 0;
    numGetOutCards = 0;
    position = 0;
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
  }
  
  public int getRoll()
  {
	  int i = (int) Math.random() * 6;
	  int j = (int) Math.random() * 6;
	  System.out.println("Rolled a " + i + " and a " + j);
	  if (i == j) {doublesCount++;}
	  pastRoll = i+j;
	  return pastRoll;
  }
  public int prevRoll()
  {
	  return pastRoll;
  }
  public void move() {
	  int r = getRoll();
	  if (doublesCount == 3) {goToJail();}
	  else if (location + r > 40)
	  {
		  goTo((location + r) % 40);
		  changeMoney(200);
	  }
	  else
	  {
		  goTo(location + r);
	  }
  }
  
  public void changeTurn() {
    isTurn = !isTurn;
    doublesCount = 0;
  }
  
  public void addRailroad() {railroadCount++;}
  public void removeRailroad() {railroadCount--;}
  public int getRailroad() {return railroadCount;}
  
}
