public class Deck {
    private Card[] deck;
    private int cardsUsed;

    public Deck() {
        deck = new Card[52];
        int cardCt = 0; // How many cards have been created so far.
        for (int suit = 1; suit <= 4; suit++) {
            char color;
            if (suit == 2 || suit == 3) {
                color = 'R';
            } else {
                color = 'B';
            }
            for (char value : new char[] { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' }) {
                deck[cardCt] = new Card(color, suit, value, false);
                cardCt++;
            }
        }
        cardsUsed = 0;
    }

    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    public Card dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
}
