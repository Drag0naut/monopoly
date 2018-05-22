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
    jailTurns = 3;
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
	  return i + j;
  }
  public void move() {
	  int r = getRoll();
	  if (location + r > 40)
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
  }
  
}
