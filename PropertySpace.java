public class PropertySpace extends Space {
  
  private int position;
  private int price;
  private int rent;
  private int mortgage;
  
  public Property(int pos, int pr, int r, int m) {
    position = pos;
    price = pr;
    rent = r;
    mortgage = m;
  }
}
