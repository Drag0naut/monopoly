
public class Tax implements Space {
  
  private int position;
  private int tax;
  
  public Tax(int p, int t) {
    position = p;
    tax = t;
  }
  
  public void act(Player p) {
    p.changeMoney(0 - tax);
    FreeParking.changeMoney(tax);
  }
  
}
