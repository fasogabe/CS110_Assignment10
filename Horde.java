// Fabian Gaspero-Beckstrom
// CS 110
// Assignment#10 Horde (Hand) Class

package HW10;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fasogabe
 */
public class Horde extends Deck {
    
    private ArrayList<Card> battalion = new ArrayList<>();
    private ArrayList<Card> reinforcements = new ArrayList<>();
    
    /**
     * Default constructor calls superclass constructor to create new deck,
     * shuffles the deck, then adds half the deck to players hand.
     */
    public Horde() {
        super(true);
        for (int i = 0; i < 26; i++) {
            battalion.add(super.draw());
        }   
    }
    
    /**
     * The getSize method returns the number of cards in the hand
     * @return The size of the hand
     */
    public int getSize() {
        return battalion.size();
    }
    
    /**
     * The peek method returns the top card of in the battalion arraylist
     * without removing it.
     * @return
     */
    public Card peek() {
        Card top = battalion.get(0);
        return top;
    }
    
    /**
     * Draw method retrieves top card from hand and removes it from the array list.
     * @return The top Card object in the battalion array list.
     */
    @Override
    public Card draw() {
        Card top = battalion.get(0);
        battalion.remove(0);
        return top;   
    }
    
    /**
     * The enlistReinforcements method adds the cards gained from won battles
     * back into the battalion arraylist.
     */
    public void enlistReinforcements() {
        shuffleReinforcements();
        for (Card soldier : reinforcements) {
            battalion.add(soldier);
        } reinforcements = new ArrayList<>();
    }
    
    /**
     * The shuffleReinforcements method shuffles the reclaimed cards in the
     * reinforcements array list.
     */
    public void shuffleReinforcements() {
        int randNum;
        Card temp;
        Random rnd = new Random();
        for (int i = 0; i < reinforcements.size(); i++) {
            randNum = rnd.nextInt(reinforcements.size());
            temp = reinforcements.get(i);
            reinforcements.set(i,reinforcements.get(randNum));
            reinforcements.set(randNum,temp);
        }      
    }
    
    /**
     * The takePows method adds the two cards gained from last battle to the
     * reinforcements array.
     * @param pow The other player's lost card
     * @param hero Your winning card
     */
    public void takePows(Card pow, Card hero) {
        reinforcements.add(pow);
        reinforcements.add(hero);
        
    }

    /**
     * The resurrect method adds the cards gained from a war into the
     * reinforcements arraylist.
     * @param dead Arraylist containing cards from last war
     */
    public void resurrect(ArrayList dead) {
        for (Object body : dead) {
            reinforcements.add((Card) body);
        }
    }
}
