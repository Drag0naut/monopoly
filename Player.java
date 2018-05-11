
public class Player {
  
  private String name;
  private int money;
  private int properties;
  private int position;
  
  public Player(String n) {
    name = n;
    money = 1500;
    properties = 0;
    position = 0;
  }
  
  public void move() {
    int r1 = (int) (Math.random() * 6) + 1;
		int r2 = (int) (Math.random() * 6) + 1;
    int newPosition = position + r1 + r2;
		if (newPosition <= 40) {
      position = newPosition;
    } else {
      position = 40 - newPosition;
    }   
  }
