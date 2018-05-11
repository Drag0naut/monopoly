
public class Die {
	/*
	 * Simulates dice roll. 
	 */
	public static int roll()
	{
		int r1 = (int) (Math.random() * 6) + 1;
		int r2 = (int) (Math.random() * 6) + 1;
		return r1 + r2;
	}
	
	//tester
	public static void main (String[] args)
	{
		System.out.println(roll());
	}
}
