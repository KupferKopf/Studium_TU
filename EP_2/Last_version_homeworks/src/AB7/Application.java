package AB7;

import AB7.Interfaces.Dealer;
import AB7.Interfaces.Deck;
import AB7.Interfaces.Hand;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        //BJCard bj = new BJCard(null, null);



        // create a dealer with a new deck
        Deck casinoDeck = new BJDeck();
        Dealer dealer = new BJDealer(casinoDeck);

        // create a player
        BJHand hand = new BJHand();
        BJPlayer player = new BJPlayer(hand, dealer);

        // before the games start, shuffle the dealer's deck
        dealer.shuffleDeck();

        // now run interactive games of Blackjack
        boolean gameLoop = true;
        while (gameLoop) {

            // start game for player drawing a starting hand
            Hand playerStartingHand = player.startGame();

            // prepare starting hand for the dealer
            // due to specific Blackjack rules, the dealer's hand has to be constructed upfront
            Hand dealerStartingHand = new BJHand();
            dealerStartingHand.addCard(dealer.dealCard());
            dealerStartingHand.addCard(dealer.dealCard());

            System.out.println("---------------------------------------");
            System.out.println("Dealer has: " + dealerStartingHand + " (" + dealerStartingHand.getScore() + ")");
            System.out.println("Player has: " + playerStartingHand + " (" + playerStartingHand.getScore() + ")");
            System.out.println("---------------------------------------");


            if (player.getScore() != 100) {
                if (dealerStartingHand.getScore() != 100) {   // no draw so lets play
                    // player starts
                    Hand playerHand;

                    Scanner scanner = new Scanner(System.in);
                    boolean loop = true;
                    while (loop) {
                        System.out.println("What do you want to do? [ (h)it, (s)tay ,(q)uit ]?");
                        char c = scanner.next().charAt(0);
                        switch (c) {
                            case 'h':   // hit -> get another card
                                playerHand = player.hit();
                                System.out.println("new hand: " + playerHand + " (" + player.getScore() + ")");
                                if (player.getScore() == 0) {
                                    loop = false;
                                    System.out.println("BUSTED!");
                                }
                                break;
                            case 's':   // stay -> no more cards
                                System.out.println("Player stays. The final hand is: " + " (" + player.getScore() + ")");
                                loop = false;
                                break;
                            case 'q':
                                System.out.println("Quitting...");
                                loop = false;
                                gameLoop = false;
                                break;
                            default:
                                System.out.println("Invalid input!");
                        }
                    }

                    // then the dealer
                    Hand dealerHand = dealerStartingHand.clone();
                    int dealerScore = dealer.playAction(dealerHand);
                    System.out.println("Dealer final hand:" + dealerHand + " (" + dealerHand.getScore() + ")");
                    if (dealerScore == 0) {
                        System.out.println("BUSTED!");
                    }
                    System.out.println("---------------------------------------");
                    System.out.println((dealerScore > player.getScore()) ? "Player loses." :
                            (player.getScore() > dealerScore) ? "Player wins!" : "Draw");
                } else {
                    System.out.println("Dealer wins with Blackjack!");
                }
            } else {
                System.out.println("Player wins with Blackjack!");
            }
            System.out.println("=======================================");

            System.out.println();
        }

        // TODO: implementation of any developer specific tests (optional)

    }
}
