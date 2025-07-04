package AB7;

import AB7.Interfaces.Card;
import AB7.Interfaces.Hand;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Represents a hand of cards in a game of Blackjack.
 * The hand consists of a collection of cards and provides functionality to add
 * cards and calculate the hand's current score based on Blackjack rules.
 */
public class BJHand implements Hand {
    private ArrayList<Card> cards;


    /**
     * Constructs a new BJHand object representing a hand of cards in Blackjack.
     *
     * <p>Initializes an empty collection of cards, which will be used to store the cards
     * in the player's hand. The hand starts empty but can be populated by adding cards
     * during the game.</p>
     */
    public BJHand() {
        cards = new ArrayList<>();
    }

    /**
     * Checks whether the current hand is a Blackjack.
     * A Blackjack is defined as a hand containing exactly two cards
     * whose combined score equals 21.
     *
     * @return true if the hand contains exactly two cards and their total score is 21, false otherwise
     */
    private boolean isBlackJack() {
        if(cards.size() != 2) return false;

        int count = 0;
        for( Card c : cards) {
            count += c.getScore();
        }

        return count == 21;
    }

    /**
     * Adds a card to the current hand in a Blackjack game and returns the hand's new total score.
     *
     * <p>If the hand is in a "busted" state (total score exceeds 21) or is a Blackjack, it is considered locked.
     * An attempt to add a card will throw an IllegalOperationException as that specific hand can no longer be modified.</p>
     *
     * @param card the card to be added to the hand. Must not be {@code null}.
     * @return the updated total score of the hand after adding the card.
     * @throws IllegalOperationException if the hand is in a "busted" state or a Blackjack, and a card is added.
     */
    @Override
    public int addCard(Card card) throws IllegalOperationException {

        if(!cards.isEmpty()) {
            int score = getScore();
            if (score == 100 || score == 0)
                throw new IllegalOperationException("Hand is locked cause of BJ(21) or Bust(0)");
        }
        if(card == null) throw new IllegalOperationException("Card mustn be null");


        cards.add(card);

        return getScore();
    }

    /**
     * Calculates and retrieves the total score of the current hand in a Blackjack game.
     *
     * <p>The method determines the total score based on the following rules:<br>
     * - If the hand is a Blackjack (exactly two cards totaling 21), it returns a score of 100.<br>
     * - Any aces are evaluated as either 1 or 11, choosing the card's score that maximizes the total score without exceeding 21.<br>
     * - If the total score exceeds 21, the hand is considered "busted" and the score becomes 0.<br>
     * - Otherwise, the score is the sum of all cards' score contained within the hand.</p>
     *
     * @return the total score of the current hand.<br>
     * - If the hand is a Blackjack, returns 100.<br>
     * - If the hand is busted, returns 0.<br>
     * - Otherwise, returns the calculated score based on the hand's cards.
     */
    @Override
    public int getScore() {

        if(isBlackJack()) return 100;

        int count = 0;
        int aceCount = 0;
        for( Card c : cards){
            if(c.getValue() == Card.Value.ACE) aceCount ++;
            else count += c.getScore();
        }

        while (0 < aceCount) {
            aceCount--;
            if(count + 11 > 21 - aceCount) count ++;
            else count += 11;
        }

        if(count > 21) return 0;
        return count;

    }

    /**
     * Removes all cards from the current hand, effectively resetting it to an empty state.
     *
     * <p>This method is used to clear the hand of all cards, which may be necessary
     * when resetting the game, starting a new round, or when the hand needs to be emptied for other reasons.</p>
     */
    @Override
    public void clear() {
        cards = new ArrayList<>();
    }

    /**
     * Creates and returns a deep copy of this BJHand object.
     * Each card in the hand is also cloned to ensure a completely independent copy.
     *
     * @return a deep copy of this BJHand or null if the clone operation fails.
     */
    @Override
    public Hand clone(){
        try {
            BJHand newHand = new BJHand();
            for (Card c : cards) {
                Card temp = new BJCard(c.getSuit(), c.getValue());
                newHand.addCard(temp);
            }

            return newHand;
        }catch (Exception e){
            System.out.println("| Something went wrong :/ | " + e.getMessage());
            return null;
        }
    }

    /**
     * Returns a string representation of the Blackjack hand.
     *
     * @return a string representing the Blackjack hand, where cards are listed in the order they appear.
     */
    @Override
    public String toString() {

        String ret = "";

        for (int i = 0; i < cards.size()-1; i++) {
            ret += cards.get(i).toString() + " and ";
        }
        try {
            return ret + cards.getLast().toString();
        }catch (NoSuchElementException n){
            return ret;
        }
    }
}
