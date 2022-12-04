import java.util.*;

public class Pillars extends Checks {

    private Stack<Card> Clubs;
    private Stack<Card> Diamonds;
    private Stack<Card> Hearts;
    private Stack<Card> Spades;
    private ArrayList<Stack<Card>> Suits;

    // (Zander) Created an arraylist called "Suits" which contains the suit stacks
    public Pillars() {
        Clubs = new Stack<Card>();
        Diamonds = new Stack<Card>();
        Hearts = new Stack<Card>();
        Spades = new Stack<Card>();
        Suits = new ArrayList<Stack<Card>>();
        Suits.add(Hearts);
        Suits.add(Diamonds);
        Suits.add(Clubs);
        Suits.add(Spades);
    }

    // Add a card to the pillar
    public void addCard(Card card, char suit) {
        if(canMoveCardToPillar(card, suit)){
            if(suit == 'C'){
                Clubs.push(card);
            }
            else if(suit == 'D'){
                Diamonds.push(card);
            }
            else if(suit == 'H'){
                Hearts.push(card);
            }
            else if(suit == 'S'){
                Spades.push(card);
            }
        }
    }

    // Remove the top card of the pillar
    public Card removeCard(char suit) {
        if(suit == 'C'){
            return Clubs.pop();
        } else if(suit == 'D'){
            return Diamonds.pop();
        } else if(suit == 'H'){
            return Hearts.pop();
        } else if(suit == 'S'){
            return Spades.pop();
        } else {
            throw new IllegalArgumentException("Must be a valid suit (C, D, H, S) and a char type not a string");
        }
    }

    // Peak at all the top cards of the pillars
    public HashMap<Character, Card> peakCardsAsHashMap() {
        HashMap<Character, Card> cards = new HashMap<Character, Card>();
        try{
            cards.put('C', Clubs.peek());
        } catch (EmptyStackException e) {
            cards.put('C', null);
        }
        try{
            cards.put('D', Diamonds.peek());
        } catch (EmptyStackException e) {
            cards.put('D', null);
        }
        try{
            cards.put('H', Hearts.peek());
        } catch (EmptyStackException e) {
            cards.put('H', null);
        }
        try{
            cards.put('S', Spades.peek());
        } catch (EmptyStackException e) {
            cards.put('S', null);
        }
        return cards;
    }

    // Peak at all the top cards of the pillars
    public ArrayList<Card> peakCardsAsArrayList() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(Clubs.peek());
        cards.add(Diamonds.peek());
        cards.add(Hearts.peek());
        cards.add(Spades.peek());
        return cards;
    }
    
    //Determin if a pillar is empty
    public boolean isEmpty(char suit){
        if(suit == 'C'){
            return Clubs.isEmpty();
        } else if(suit == 'D'){
            return Diamonds.isEmpty();
        } else if(suit == 'H'){
            return Hearts.isEmpty();
        } else if(suit == 'S'){
            return Spades.isEmpty();
        } else {
            throw new IllegalArgumentException("Must be a valid suit (C, D, H, S) and a char type not a string");
        }
    }



}
