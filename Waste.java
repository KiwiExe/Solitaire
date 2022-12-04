import java.util.*;

public class Waste {
    private Stack<Card> cards;
    private int size;

    public Waste() {
        cards = new Stack<Card>();
        size = 0;
    }

    // Add a card to the waste
    public void addCard(Card card) {
        cards.push(card);
        size++;
    }

    // Remove look at the top card of the waste
    public Card returnTopCard() {
        return cards.peek();
    }

    // Return the top card of the waste as a string
    public String revealCardAsString() {
        try{
        return cards.peek().toShortString();
        } catch (EmptyStackException e) {
            return "Empty";
        }
    }

    // Remove the top card of the waste
    public Card removeCard() {
        size--;
        return cards.pop();
    }

    // Empty the waste
    public LinkedList<Card> empty() {
        LinkedList<Card> pile = new LinkedList<Card>();
        while (!cards.isEmpty()) {
            pile.add(cards.pop());
        }
        size = 0;
        return pile;
    }

    // Get the size of the waste
    public int getSize() {
        return size;
    }

    // Check if the waste is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
}
