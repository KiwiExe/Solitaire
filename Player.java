import java.util.*;

public class Player extends Checks {

    private Card card;
    private LinkedList<Card> cards;

    // Getters
    // Use one card
    public Card getCard() {
        return card;
    }

    // Use for multiple cards
    public LinkedList<Card> getCards() {
        return cards;
    }

    // Setters
    // Can ony hold one card or series of cards at a time

    public void setCard(Card card) {
        this.cards = null;
        this.card = card;
    }

    public void setCards(LinkedList<Card> cards) {
        this.card = null;
        this.cards = cards;
    }

}
