
public class FreeParking implements Space {

  private static int money;
  
  public FreeParking() {
    money = 100;
  }
  
  public static void act(Player p) {
    p.changeMoney(money);
    money = 100;
  }
  
  public static void changeMoney(int tax) {
    money += tax;
  }
  
}
