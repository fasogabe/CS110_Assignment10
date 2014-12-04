// Fabian Gaspero-Beckstrom
// CS 110
// Assignment#10 Battle Class

package HW10;

import java.util.ArrayList;

/**
 * The Battle class simulates a game of war between two players
 * @author Fasogabe
 */
public class Battle {
    
    private Horde usrHand; // holds the users current card
    private Horde cpuHand; // hold the opponents current card
    
    /**
     * Default constructor creates two new hordes. One for the user and one for
     * the cpu. Only two hordes can be created.
     */
    public Battle() {
        usrHand = new Horde();
        cpuHand = new Horde();
    }
    
    /**
     * The getUsrNumbers method returns the remaining amount of cards in the
     * users hand.
     * @return the size of the users hand
     */
    public int getUsrNumbers() {
        return usrHand.getSize();
    }

    /**
     * The getCpuNumbers method returns the remaining amount of cards in the
     * cpu's hand.
     * @return the size of the cpu's hand
     */
    public int getCpuNumbers() {
        return cpuHand.getSize();
    }
    
    /**
     * The usrCharge method returns the top card in the users hand without
     * removing it.
     * @return the top card in users hand
     */
    public Card usrCharge() {
        Card usrCard = usrHand.peek();
        return usrCard;
    }
    
    /**
     * The cpuCharge method returns the top card in the cpu's hand without
     * removing it.
     * @return the top card in cpu's hand
     */
    public Card cpuCharge() {
        Card cpuCard = cpuHand.peek();
        return cpuCard;
    }
    
    /**
     * The showdown method executes a single round of the game by drawing the
     * top card from each players hand and determining the winning card. The
     * cards are thereafter given back to the winner.
     */
    public void showdown() {
        Card usrCard = usrHand.draw();
        Card cpuCard = cpuHand.draw();
        ArrayList<Card> bodyPile = new ArrayList<>();
        int warCount = 0;
        while (usrCard.sameRank(cpuCard)) { // war
            Card uDead = usrHand.draw(); // user discards one card
            Card cDead = cpuHand.draw(); // cpu discards one card
            bodyPile.add(uDead); // add to bodypile
            bodyPile.add(cDead); // add to bodypile
            warCount++;
            showdown(); // draw again
            
        } if (usrCard.getRank() > cpuCard.getRank()) { // user wins round
            if (warCount > 0) { // resurrect bodies
                usrHand.resurrect(bodyPile);
                bodyPile = null;
            } 
            usrHand.takePows(cpuCard, usrCard);
        } else if (usrCard.getRank() < cpuCard.getRank()) { // cpu wins round
            if (warCount > 0) { // resurrect bodies
                cpuHand.resurrect(bodyPile);
                bodyPile = null;
            } 
            cpuHand.takePows(cpuCard, usrCard);
        }
    }
    
    /**
     * The reinforce method calls the enlistReinforcements method in the Horde
     * class.
     */
    public void reinforce() {
        usrHand.enlistReinforcements();
        cpuHand.enlistReinforcements();
    }
    
}
