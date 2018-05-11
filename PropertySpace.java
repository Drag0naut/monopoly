public class PropertySpace extends Space {
  
  private int position;
  private int price;
  private int rent;
  private int rentOneH;
  private int rentTwoH;
  private int rentThreeH;
  private int rentFourH;
  private int rentHotel;
  private int houseCost;
  private int mortgage;
  
  public Property(int pos, int pr, int r, int or, int twr, int thr, int fr, int hr, int houc, int m) {
    position = pos;
    price = pr;
    rent = r;
    rentOneH = or;
    rentTwoH = twr;
    rentThreeH = thr;
    rentFourH = fr;
    rentHotel = hr;
    houseCost = houc;
    mortgage = m;
  }
}
