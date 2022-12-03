public class Board extends Player {
    private static Table table;
    private static Pillars pillars;
    private static Hand hand;
    private static Waste waste;

    
    public Board() {
        table = new Table();
        pillars = new Pillars();
        hand = new Hand();
        waste = new Waste();
    }



    public static void main(String[] args) {
        dealNewGame();
        
    }

    // Deal a new game
    public static void dealNewGame() {
        // Create a new deck
        Deck deck = new Deck();

        // Shuffle the deck
        deck.shuffle();
        
        // Deal the cards to the table
        for (int i = 1; i <= 7; i++) {
            for (int j = i; j <= 7 ; j++) {
                //Last card of every column should be face up
                if (j == i) {
                    table.addCard(deck.dealCard(), j, true);
                } else {
                    table.addCard(deck.dealCard(), j);                    
                }
            }
        }

        // Deal the rest of the cards to the hand
        while(deck.cardsLeft() > 0){
            hand.addCard(deck.dealCard());
        } 
    }
    
    // Display the board
    public static void displayBoard(Pillars pillars) {
        // Display the pillars
        System.out.println("Pillars: ");
        System.out.println("     " + "Clubs: " + pillars.peakCardsAsHashMap().get('C'));
        System.out.println("     " + "Diamonds: " + pillars.peakCardsAsHashMap().get('D'));
        System.out.println("     " + "Hearts: " + pillars.peakCardsAsHashMap().get('H'));
        System.out.println("     " + "Spades: " + pillars.peakCardsAsHashMap().get('S'));

        // Display the table
        System.out.println("Table: ");


        
        // Display the hand
        // Display the waste
    }
}
