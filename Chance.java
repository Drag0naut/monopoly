public class Chance implements Space {
    public void act(Player p) {
        int ran = (int) Math.random() * 16;
        if (ran == 0)
        {
            p.goTo(0); // go to  go space
        }
        if (ran == 1)
        {
            p.goTo(x); //x = illinoisave, go to  Illinois Ave.
        }
        if (ran == 2)
        {
            p.goTo(x); // x = stcharlesplace, go to st charles place
        }
        if (ran == 3)
        {
        	//implement the roll
            if (p.getPos() < x || p.getPos() > y) // x = pos of first util, y = pos of last util
            {
            	p.move(x);
            }
            else
            {
            	p.move(y);
            }
            	
            	// go to  closest utility,  if owned, pay ten  times dice roll
        }
        if (ran == 4)
        {
            // go to closest railroad,  pay twice as  much as you  normally would
        }
        if (ran == 5)
        {
            p.changeMoney(50);//give 50 bucks to  player
        }
        if (ran == 6)
        {
            p.addGetOutOfJailFreeCard();//get out of jail  free card
        }
        if (ran == 7)
        {
            p.move(p.getPos() - 3);// go back  3 spaces
        }
        if (ran == 8)
        {
            p.move();// go  to jail
        }
        if (ran == 9)
        {
        	int i = 0;
        	i += p.getHouses() * 25;
        	i += p.getHotels() * 100;
            p.changeMoney(0-i); //25 bucks foreach house, 100 for each hotel owned
        }
        if (ran == 10)
        {
            p.changeMoney(0-15);// 15 $ tax
        }
        if (ran == 11)
        {
        	int i = ; // whatever reading railroad is in the array
        	if (p.getPos()) > i) {p.changeMoney(200);}
            p.move(i); //go to reading railroad, if pass go,  collect 200
        }
        
        if (ran == 12)
        {
            p.move(); // go  to  boardwalk
        }
        if (ran == 13)
        {
            p.changeMoney(0-50);
            ArrayList<Player> temp = getPlayerList();
            for (int i = 0; i < temp.size(); i++)
            {
            	if (!(temp.get(i).equals(p))) {temp.get(i).changeMoney(50);}
            }
            //pay each player $50
        }
        if (ran == 14)
        {
            p.changeMoney(150); //collect $150
        }
        if (ran == 15)
        {
            p.changeMoney(100);//collect $100
        }
        
    }
