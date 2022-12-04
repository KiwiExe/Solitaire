import java.util.*;

public class Table extends Checks {
    private LinkedList<Card> Column1;
    private LinkedList<Card> Column2;
    private LinkedList<Card> Column3;
    private LinkedList<Card> Column4;
    private LinkedList<Card> Column5;
    private LinkedList<Card> Column6;
    private LinkedList<Card> Column7;
    public String getNumCards;

    // Constructor
    public Table() {
        Column1 = new LinkedList<Card>();
        Column2 = new LinkedList<Card>();
        Column3 = new LinkedList<Card>();
        Column4 = new LinkedList<Card>();
        Column5 = new LinkedList<Card>();
        Column6 = new LinkedList<Card>();
        Column7 = new LinkedList<Card>();
    }

    // Add a card to the table
    public void addCard(Card card, int column) {
        if(canMoveCardToTable(card, column)){
            switch (column) {
                case 1:
                    Column1.add(card);
                    break;
                case 2:
                    Column2.add(card);
                    break;
                case 3:
                    Column3.add(card);
                    break;
                case 4:
                    Column4.add(card);
                    break;
                case 5:
                    Column5.add(card);
                    break;
                case 6:
                    Column6.add(card);
                    break;
                case 7:
                    Column7.add(card);
                    break;
                default:
                    throw new IllegalArgumentException("Column must be 1-7");
                }
            } else {
            throw new IllegalArgumentException("Card cannot be added to table");
        }
    }

    // Add a card to the table with a face up (true) or face down (false) boolean
    public void addCard(Card card, int column, boolean faceUp){
            card.setFaceUp(faceUp);
            addCard(card, column);
    }
    

    //Add a series of cards to the table
    public void addCards(LinkedList<Card> cards, int column) {
        if(canMoveSeriesToTable(cards, column)){
            switch (column) {
                case 1:
                    Column1.addAll(cards);
                    break;
                case 2:
                    Column2.addAll(cards);
                    break;
                case 3:
                    Column3.addAll(cards);
                    break;
                case 4:
                    Column4.addAll(cards);
                    break;
                case 5:
                    Column5.addAll(cards);
                    break;
                case 6:
                    Column6.addAll(cards);
                    break;
                case 7:
                    Column7.addAll(cards);
                    break;
                default:
                    throw new IllegalArgumentException("Column must be 1-7");
                }
            } else {
            throw new IllegalArgumentException("Cards cannot be added to table");
        }
    }

    // Remove a card from the table
    public Card removeCard(int column) {
        if(canRemoveCardFromTable(column)){
            switch (column) {
                case 1:
                    return Column1.removeLast();
                case 2:
                    return Column2.removeLast();
                case 3:
                    return Column3.removeLast();
                case 4:
                    return Column4.removeLast();
                case 5:
                    return Column5.removeLast();
                case 6:
                    return Column6.removeLast();
                case 7:
                    return Column7.removeLast();
                default:
                    throw new IllegalArgumentException("Column must be 1-7");
            }
        } else {
            throw new IllegalArgumentException("Card cannot be removed from table");
        }
    }

    // Remove a series of cards from the table
    // Currently removes the cards like a Stack. Might be worth rewriting to take more advatage of LinkedList strcture
    public LinkedList<Card> removeCard(int column, int numCards) {
        if(canRemoveSeriesFromTable(column, numCards)){
            LinkedList<Card> cards = new LinkedList<Card>();
            switch (column) {
                case 1:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column1.removeLast());
                    }
                    break;
                case 2:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column2.removeLast());
                    }
                    break;
                case 3:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column3.removeLast());
                    }
                    break;
                case 4:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column4.removeLast());
                    }
                    break;
                case 5:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column5.removeLast());
                    }
                    break;
                case 6:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column6.removeLast());
                    }
                    break;
                case 7:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column7.removeLast());
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Column must be 1-7");
            }
            return cards;
        } else {
            throw new IllegalArgumentException("Cards cannot be removed from table");
        }
    }

    // Print a column of the table
    public String columntoString(int column) {
        String temp = "";
        switch(column) {
            case 1:
                for (Card card : Column1) {
                    temp += card.toShortString() + "\n";
                }
                break;
            case 2:
                for (Card card : Column2) {
                    temp += card.toShortString() + "\n";
                }
                break;
            case 3:
                for (Card card : Column3) {
                    temp += card.toShortString() + "\n";
                }
                break;  
            case 4:
                for (Card card : Column4) {
                    temp += card.toShortString() + "\n";
                }
                break;
            case 5:
                for (Card card : Column5) {
                    temp += card.toShortString() + "\n";
                }
                break;
            case 6:
                for (Card card : Column6) {
                    temp += card.toShortString() + "\n";
                }
                break;
            case 7: 
                for (Card card : Column7) {
                    temp += card.toShortString() + "\n";
                }
                break;
            default:
                throw new IllegalArgumentException("Column must be 1-7");
        }
        return temp;
    }

    //Get the number of cards in a column
    public int getNumCards(int column) {
        switch(column) {
            case 1:
                return Column1.size();
            case 2:
                return Column2.size();
            case 3:
                return Column3.size();
            case 4:
                return Column4.size();
            case 5:
                return Column5.size();
            case 6:
                return Column6.size();
            case 7:
                return Column7.size();
            default:
                throw new IllegalArgumentException("Column must be 1-7");
        }
    }

    //Return a series of cards from a column
    public LinkedList<Card> getCards(int column, int numCards) {
        if(canRemoveSeriesFromTable(column, numCards)){
            LinkedList<Card> cards = new LinkedList<Card>();
            switch (column) {
                case 1:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column1.get(Column1.size() - numCards + i));
                    }
                    break;
                case 2:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column2.get(Column2.size() - numCards + i));
                    }
                    break;
                case 3:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column3.get(Column3.size() - numCards + i));
                    }
                    break;
                case 4:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column4.get(Column4.size() - numCards + i));
                    }
                    break;
                case 5:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column5.get(Column5.size() - numCards + i));
                    }
                    break;
                case 6:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column6.get(Column6.size() - numCards + i));
                    }
                    break;
                case 7:
                    for (int i = 0; i < numCards; i++) {
                        cards.add(Column7.get(Column7.size() - numCards + i));
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Column must be 1-7");
            }
            return cards;
        } else {
            throw new IllegalArgumentException("Cards cannot be removed from table");
        }
    }
}