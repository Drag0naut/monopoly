
public class Railroad implements Space {
  
  private int position;
  private String name;
  private String owner;
  private boolean isMortgaged;
  private static int numOwned;
  private int price;
  private int rent;
  private int mortgageCost;
  
  public Railroad(int p, String n) {
    position = p;
    name = n;
    owner = "";
    isMortgaged = false;
    numOwned = 0;
    price = 200;
    rent = 25;
    mortgageCost = 100;
  }
  
  public void act(Player p) {
    if (owner.equals("")) {
      if (p.askToBuy(getName())) {
        numOwned++;
        rent *= numOwned;
      }
    } else if (!owner.equals(p.getName())) {
      p.changeMoney(0 - rent);
    }
  }
  
  public String getName() {
    return name;
  }
  
  public int getPrice() {
    return price;
  }
  
  public int getRent() {
    return rent;
  }
  
  public int getMortgageCost() {
    return mortgageCost;
  }

}
