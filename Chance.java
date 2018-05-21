public class Chance implements Space {
    public void act(Player p) {
        int ran = (int) Math.random() * 16;
        if (ran == 0)
        {
            p.goTo(Go); // go to  go space
        }
        if (ran == 1)
        {
            p.goTo(IllinoisAvenue); //go to  Illinois Ave.
        }
        if (ran == 2)
        {
            p.goTo(StCharlesPlace); // go to st charles place
        }
        if (ran == 3)
        {
            // go to  closest utility,  if owned, pay ten  times dice roll
        }
        if (ran == 4)
        {
            // go to closest railroad,  pay twice as  much as you  normally would
        }
        if (ran == 5)
        {
            //give 50 bucks to  player
        }
        if (ran == 6)
        {
            //get out of jail  free card
        }
        if (ran == 7)
        {
            // go back  3 spaces
        }
        if (ran == 8)
        {
            // go  to jail
        }
        if (ran == 9)
        {
            //25 bucks foreach house, 100 for each hotel owned
        }
        if (ran == 10)
        {
            // 15 $ tax
        }
        if (ran == 11)
        {
            //go to reading railroad, if pass go,  collect 200
        }
        
        if (ran == 12)
        {
            // go  to  boardwalk
        }
        if (ran == 13)
        {
            //pay each player $50
        }
        if (ran == 14)
        {
            p.addMoney(150); //collect $150
        }
        if (ran == 15)
        {
            //collect $100
        }
        
    }
}
