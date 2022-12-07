import java.util.*;

/*
 * TODO:
 * 
 * 1. Rewrite using new data structures
 * 2. Change movesLeft to gameWon
 * 3. Handle face down cards with a break to the gameplay loop
 * 4. 
 */

public class Board extends Player {
    private static Table table;
    private static Pillars pillars;
    private static Hand hand;
    private static Waste waste;

    public static void main(String[] args) {
        table = new Table();
        pillars = new Pillars();
        hand = new Hand();
        waste = new Waste();

        Player player = new Player();
        dealNewGame();
        displayBoard(pillars, table, hand, waste);

        // Gamplay Loop
        // Get user input
        Scanner input = new Scanner(System.in);
        while (Checks.movesLeft()) {

            /*
             * 1. Pick up a card from the table
             */
            do {
                // Selct a pile
                String pile = "";
                player.setCard(null);
                player.setCards(null);
                System.out.println();
                System.out.println("Select Pile: ");
                do {
                    System.out.println("Plese enter a valid pile: Hand, 1...7, Waste, C, D, H, S");
                    pile = input.nextLine();
                } while (!pile.equals("Hand") && !pile.equals("Waste") && !pile.equals("C") && !pile.equals("D")
                        && !pile.equals("H") && !pile.equals("S") && !pile.equals("1") && !pile.equals("2")
                        && !pile.equals("3") && !pile.equals("4") && !pile.equals("5") && !pile.equals("6")
                        && !pile.equals("7"));

                // If the player selected a column, get the card number
                int cardNumber = 0;
                if (pile.equals("1") || pile.equals("2") || pile.equals("3") || pile.equals("4") || pile.equals("5")
                        || pile.equals("6") || pile.equals("7")) {
                    System.out.println("Select Card Number: ");
                    do {
                        System.out.println(
                                "Please enter an integer between 1 and " + table.getNumCards((Integer.parseInt(pile))));
                    } while (cardNumber < 1 || cardNumber > table.getNumCards((Integer.parseInt(pile))));

                    if (Checks.canRemoveSeriesFromTable(Integer.parseInt(pile), cardNumber)) {
                        player.setCards(table.removeCard(Integer.parseInt(pile), cardNumber));
                    } else {
                        System.out.println("You can't remove that series of cards");
                    }
                }

                // If the player selected Hand or Waste remove the top card
                if (pile.equals("Hand")) {
                    if (hand.isEmpty()) {
                        System.out.println("Hand is empty");
                    } else {
                        player.setCard(hand.removeCard());
                    }
                }
                if (pile.equals("Waste")) {
                    if (waste.isEmpty()) {
                        System.out.println("Waste is empty");
                    } else {
                        player.setCard(waste.removeCard());
                    }
                }

                // If the player selected a suit, remove the top card
                if (pile.equals("C")) {
                    if (pillars.isEmpty('C')) {
                        System.out.println("Clubs is empty");
                    } else {
                        player.setCard(pillars.removeCard('C'));
                    }
                }
                if (pile.equals("D")) {
                    if (pillars.isEmpty('D')) {
                        System.out.println("Diamonds is empty");
                    } else {
                        player.setCard(pillars.removeCard('D'));
                    }
                }
                if (pile.equals("H")) {
                    if (pillars.isEmpty('H')) {
                        System.out.println("Hearts is empty");
                    } else {
                        player.setCard(pillars.removeCard('H'));
                    }
                }
                if (pile.equals("S")) {
                    if (pillars.isEmpty('S')) {
                        System.out.println("Spades is empty");
                    } else {
                        player.setCard(pillars.removeCard('S'));
                    }
                }
            } while (player.getCard() == null && player.getCards() == null);

            /*
             * 2. Place the card on the table
             */

            System.out.println();
            if (player.getCard() != null) {
                System.out.println("You are holding: " + player.getCard().toString());
            }
            if (player.getCards() != null) {
                System.out.println("You are holding: " + player.getCards().toString());
            }

        }
        input.close();

    }

    // Deal a new game
    public static void dealNewGame() {
        // Create a new deck
        Deck deck = new Deck();

        // Shuffle the deck
        deck.shuffle();

        // Deal the cards to the table
        for (int i = 1; i <= 7; i++) {
            for (int j = i; j <= 7; j++) {
                // Last card of every column should be face up
                if (j == i) {
                    table.addCard(deck.dealCard(), j, true);
                } else {
                    table.addCard(deck.dealCard(), j);
                }
            }
        }

        // Deal the rest of the cards to the hand
        while (deck.cardsLeft() > 0) {
            hand.addCard(deck.dealCard());
        }
    }

    // Display the board
    public static void displayBoard(Pillars pillars) {
        // Display the pillars
        HashMap<Character, Card> tempPillars = pillars.peakCardsAsHashMap();
        System.out.println("Pillars: ");
        if (tempPillars.containsKey('C')) {
            System.out.println("     " + "Clubs: " + tempPillars.get('C'));
        } else {
            System.out.println("     " + "Clubs: " + "Empty");
        }
        if (tempPillars.containsKey('D')) {
            System.out.println("     " + "Diamonds: " + tempPillars.get('D'));
        } else {
            System.out.println("     " + "Diamonds: " + "Empty");
        }
        if (tempPillars.containsKey('H')) {
            System.out.println("     " + "Hearts: " + tempPillars.get('H'));
        } else {
            System.out.println("     " + "Hearts: " + "Empty");
        }
        if (tempPillars.containsKey('S')) {
            System.out.println("     " + "Spades: " + tempPillars.get('S'));
        } else {
            System.out.println("     " + "Spades: " + "Empty");
        }
        System.out.println();
    }

    public static void displayBoard(Table table) {
        // Display the table
        System.out.println("Table: ");
        for (int i = 1; i <= 7; i++) {
            System.out.println("     " + "Column " + i + ": ");
            System.out.println(table.columntoString(i));
        }
        System.out.println();
    }

    public static void displayBoard(Hand hand) {
        // Display the hand size
        System.out.println("Hand: " + hand.getSize() + " cards");
        System.out.println();
    }

    public static void displayBoard(Waste waste) {
        // Display the waste top card
        System.out.println("Waste: " + waste.revealCardAsString());
        System.out.println();

    }

    public static void displayBoard(Pillars pillars, Table table, Hand hand, Waste waste) {
        displayBoard(hand);
        displayBoard(waste);
        displayBoard(pillars);
        displayBoard(table);

    }
}
