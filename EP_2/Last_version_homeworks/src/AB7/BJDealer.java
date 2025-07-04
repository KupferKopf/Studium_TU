package AB7;

import AB7.Interfaces.Card;
import AB7.Interfaces.Dealer;
import AB7.Interfaces.Deck;
import AB7.Interfaces.Hand;

/**
 * Represents a BlackJack dealer, responsible for managing the deck of cards,
 * dealing cards to players, shuffling the deck, and performing necessary dealer actions
 * within the context of a BlackJack game.
 *
 * <p>This class implements the Dealer interface, which defines the operations
 * that a dealer must perform, such as dealing cards, shuffling the deck, and participating in the game.</p>
 */
public class BJDealer implements Dealer {
    // TODO: uncomment this declaration. Do not alter its signature!
    private final Deck deck;  // the deck of cards the dealer operates with

    // TODO: variable declarations (optional)

    /**
     * Constructs a new BJDealer object and initializes it with the specified deck of cards.
     * The deck is shuffled upon initialization to ensure random card order.
     *
     * @param deck the deck of cards that the dealer will manage and operate during the game.
     *             It must not be {@code null}.
     */
    public BJDealer(Deck deck) {
        this.deck = deck;
    }

    /**
     * Deals a card from the deck. If the deck is out of cards, it reshuffles and tries again.
     * If no card can be dealt even after reshuffling, a BadDeckException is thrown.
     *
     * @return the next card from the deck
     * @throws BadDeckException if the deck cannot provide any card even after reshuffling
     */
    @Override
    public Card dealCard() throws BadDeckException {

        try{
            return deck.drawCard();
        }catch (OutOfCardsException outCarde){
            try{
                shuffleDeck();
                return deck.drawCard();
            }catch(OutOfCardsException outCardetwo){
                throw new BadDeckException("deck is fucked up (no cards fam) not sure what the hell you did man", outCardetwo);
            }
        }


    }

    /**
     * Shuffles the deck of cards managed by the dealer.
     */
    @Override
    public void shuffleDeck() {
        deck.shuffle();
    }

    /**
     * Executes the dealer's play action in the context of a BlackJack game.
     *
     * <p>A Blackjack dealer executes its turn following specific rules:<br>
     * - The dealer starts with a hand containing two cards. A reference to the start hand is passed to this method
     * as parameter {@code dealerHand}.<br>
     * - If the start hand is a Blackjack, the hand's score (score of a Blackjack) is returned immediately and the
     * dealer's play action is finished.<br>
     * - The dealer has to draw additional cards as long as its hand's score is less or equal to 16.<br>
     * - The dealer stops adding cards to its hand if its hand's score is 17 or more and stops its play action by
     * returning the final hand score.<br>
     * - The dealer loses (is busted) if his hand's score is greater than 21 and ends its play action by returning 0.<br>
     * <p>
     * If the dealer hand contains an ace, the ace is counted as 11 as long as the hand is not busted.
     * If an ace's score of 11 leads to a bust (score over 21), the ace's score is counted as 1 instead.</p>
     *
     * @param dealerHand a reference to the hand of cards the dealer was assigned for play. Must not be {@code null}
     *                   and must contain exactly two cards for a Blackjack dealer.
     * @return an integer representing the result of the dealer's action:
     * - 100 if the dealer hand is a Blackjack
     * - the hand's score if the dealer hand is not busted and is not a Blackjack
     * - 0 if the dealer busted by cumulating a hand score over 21.
     */
    @Override
    public int playAction(Hand dealerHand) throws BadDeckException {

        int score = dealerHand.getScore();
        if(score == 100) return 100;
        while (score < 17 && score > 0){
            dealerHand.addCard(dealCard());
            score = dealerHand.getScore();
        }

        return score;
    }

}
