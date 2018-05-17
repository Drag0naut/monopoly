
public class Player {

  private String name;
  private int money;
  private int numHouses;
  private boolean isInJail;
  private int jailTurns;
  private int numGetOutCards;
  private int position;
  private int isTurn;
  
  public Player(String n) {
    name = n;
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
  
  public void changeMoney(int amt) {
    money += amt;
  }
  
  public void goToJail() {
    isInJail = true;
    jailTurns = 3;
  }
  
  public void drawGetOutCard() {
    if (numGetOutCards < 2) {
      numGetOutCards++;
    }
  }
  
  public void move() {
    ... //roll dice, change position
  }
  
  public void changeTurn() {
    isTurn = !isTurn;
  }
  
}
