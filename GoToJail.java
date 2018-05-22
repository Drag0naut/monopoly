
public class GoToJail implements Space {
  private int position;
  public GoToJail(pos)
  {
    position = pos;
  }
  
  public void act(Player p) {
    p.goToJail();
  }
  
}
