// Fabian Gaspero-Beckstrom
// CS 110
// Assignment#10 Deck Class
package HW10;

import java.util.Random;
import java.util.ArrayList;


/**
 * Deck Class acts like a standard 52 card deck
 * @author Fasogabe
 */
public class Deck {
    
    private ArrayList<Card> deck;
    
    /**
     * Default constructor creates a new deck of 52 Card objects in an arraylist.
     */
    public Deck() {
        newDeck();
    }
    
    /**
     * Alternate constructor creates new deck and shuffles the Cards
     * @param shuff 
     */
    public Deck(boolean shuff) {
        newDeck();
        if (shuff == true) {
            shuffle();
        }
    }
    /**
     * The newDeck method fills an arraylist with 52 Card objects.
     */
    private void newDeck() {
        deck = new ArrayList<>();
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                deck.add(new Card(rank, suit));
            }
        }
    }
    /**
     * The shuffle method rearranges the contents of the deck arraylist in a
     * random order.
     */
    private void shuffle() {
        int randNum;
        Card temp;
        Random rnd = new Random();
        for (int i = 0; i < deck.size(); i++) {
            randNum = rnd.nextInt(deck.size());
            temp = deck.get(i);
            deck.set(i,deck.get(randNum));
            deck.set(randNum,temp);
        }      
    }
    
    /**
     * The draw method returns the top card of the deck and removes it.
     * @return top The first Card object in the deck arraylist.
     */
    public Card draw() {
        Card top = deck.get(0);
        deck.remove(0);
        return top;
        
        
        
    }

    
}
