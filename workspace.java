public class workspace {
    public static void main(String[] args) {
        // Create a deck of cards
        Deck deck = new Deck();
        // Shuffle the deck
        deck.shuffle();
        // Deal the cards
        Hand hand = new Hand();
        for (int i = 0; i < 5; i++) {
            hand.addCard(deck.dealCard());
        }
        // Print the hand
        System.out.println(hand);
    }
}
