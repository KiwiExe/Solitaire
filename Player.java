import java.util.*;

public class Player extends Checks {

    private Card Card;
    private LinkedList<Card> Cards;

    // Getters
    // Use one card
    public Card getCard() {
        return Card;
    }

    // Use for multiple cards
    public LinkedList<Card> getCards() {
        return Cards;
    }

    // Setters
    // Can ony hold one card or series of cards at a time

    public void setCard(Card card) {
        this.Cards = null;
        this.Card = card;
    }

    public void setCards(LinkedList<Card> cards) {
        this.Card = null;
        this.Cards = cards;
    }

    public Card placeCard(){
        Card temp = this.Card;
        this.Card = null;
        this.Cards = null;
        return temp;

    }

    public LinkedList<Card> placeCards(){
        LinkedList<Card> temp = this.Cards;
        this.Card = null;
        this.Cards = null;       
        return temp;
    }
}
