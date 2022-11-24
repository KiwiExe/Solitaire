import java.util.Stack;

public class Hand{
    private Stack<Card> hand;
    private int size;

    public Hand() {
        hand = new Stack<Card>();
        size = 0;
    }

    public void addCard(Card card) {
        hand.push(card);
        size++;
    }

    public Card revealCard() {
        return hand.peek();
    }

    public Card removeCard() {
        size--;
        return hand.pop();
    }

    public Card getCard(int index) {
        return hand.get(index);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return hand.isEmpty();
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += hand.get(i) + " ";
        }
        return str;
    }
}

