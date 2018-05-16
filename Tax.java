
public class Tax implements Space {
  
  private int tax;
  
  public Tax(int t) {
    tax = t;
  }
  
  public void act(Player p, FreeParking fp) {
    p.changeMoney(0 - tax);
    fp.changeMoney(tax);
  }
  
}
