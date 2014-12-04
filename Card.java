// Fabian GB
// CS 110
// Assignment#10 Card Class

package HW10;

/**
 * Card class
 * @author Fasogabe
 */
public class Card {
    
    // initialize fields
    private final int suit;
    private final int rank;
    
    /**
     * Constructor sets the rank and suit fields
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit) {
        // set suit and rank
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Copy constructor
     * @param other
     */
    public Card(Card other) {
        this.suit = other.suit;
        this.rank = other.rank;
    }

    /**
     * Returns the suit
     * @return suit
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the rank
     * @return rank
     */
    public int getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        String rankStr = "";
        String suitStr = "";
        switch(rank) {
            case 11: rankStr = "jack";
                break;
            case 12: rankStr = "queen";
                break;
            case 13: rankStr = "king";
                break;
            case 1: rankStr = "ace";
                break;
            default: rankStr += rank;
        } switch (suit) {
            case 1: suitStr = "s";
                break;
            case 2: suitStr = "h";
                break;
            case 3: suitStr = "c";
                break;
            case 4: suitStr = "d";
                break;
        }
        return rankStr + suitStr;
    }

    /**
     * Returns true if ranks are equal
     * @param other 
     * @return 
     */
    public boolean sameRank(Card other) {
        return (this.getRank() == other.getRank());
    }

    /**
     * Returns true if cards are exactly equal
     * @param other
     * @return
     */
    public boolean equals(Card other) {
        return (this.getRank() == other.getRank() && this.getSuit() == other.getSuit());
    }
}
