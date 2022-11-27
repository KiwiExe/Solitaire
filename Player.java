import java.util.*;

public abstract class Player extends Checks {

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
    public void setCard(Card card) {
        this.card = card;
    }

    public void setCards(LinkedList<Card> cards) {
        this.cards = cards;
    }
    
    
}
