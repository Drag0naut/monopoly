
public class CommunityChest implements Space{
    public CommunityChest(
    public void act(Player p) {
        int ran = (int) Math.random() * 15;
        if (ran == 0)
        {
          p.goTo(Go); // Player advances to go, collects $200
        }
        if (ran == 1)
        {
          p.changeMoney(200); // Bank error in your favor – Collect $200 
        }
        if (ran == 2)
        {
          p.changeMoney(-50); //Doctor's fees {fee} – Pay $50 
        }
        if (ran == 3)
        {
         p.drawGetOutCard(); //Get Out of Jail Free
        }
        if (ran == 4)
        {
          p.goToJail();
        }
        if (ran == 5)
        {
           //Grand Opera Night {Opening} – Collect $50 from every player for opening night seats
        }
        if (ran == 6)
        {
          p.changeMoney(100); //Holiday {Xmas} Fund matures - Receive {Collect} $100 <Mr. M carries along a giant Xmas sock containing a sheaf of cash>

        }
        if (ran == 7)
        {
          p.changeMoney(20); //Income tax refund – Collect $20 <Mr M faints back against a man displaying the Refund paper>

        }
        if (ran == 8)
        {
          p.changeMoney(100); //Life insurance matures – Collect $100 <Below an I N S sign stands a bent Mr M, his long beard brushing the floor>

        }
        if (ran == 9)
        {
          p.changeMoney(-40*p.getHouses());
          p.changeMoney(-115*p.getHotels());
          //You are assessed for street repairs – $40 per house – $115 per hotel <Mr. M., supported by his near-ubiquitous cane in his left hand, holds a pick and shovel over his right shoulder>

        }
        if (ran == 10)
        {
          p.changeMoney(-100); //Pay hospital fees of $100 {Pay hospital $100} <A bored nurse holds out her hand for payment while Mr. M holds 2 swaddled infants, one in each arm>
        }
        if (ran == 11)
        {
          p.changeMoney(-150);       //Pay school fees {tax} of $150 <A bespectacled schoolboy unhappily receives a head pat and a dime ((Rockefeller style) from Mr. M.>
        }
        
        if (ran == 12)
        {
          p.changeMoney(25);       //Receive $25 consultancy fee {Receive for services $25} <As Justice of the Peace, a stern Mr. M holds out his hand for fee from an embarrassed groom whose bride hold a bouquet behind him>

        }
        if (ran == 13)
        {
          p.changeMoney(10); //You have won second prize in a beauty contest – Collect $10 <Mr. M preens with a sash and large bouquet>
        }
        if (ran == 14)
        {
          p.changeMoney(100); //You inherit $100 <Mr M. holds his head as unseen people's hands offer brochures titled "Buy Yacht", "World Tour", and "Rolls Royce">
        
    }

}
