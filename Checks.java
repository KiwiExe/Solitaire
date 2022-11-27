import java.util.*;

public abstract class Checks {

    public boolean canMoveCardToTable(Card card, int column){
        return true;
    }
    public boolean canMoveSeriesToTable(LinkedList<Card> cards, int column){
        return true;
    }
    public boolean canRemoveCardFromTable(int column){
        return true;
    }
    public boolean canRemoveSeriesFromTable(int column, int numCards){
        return true;
    }
    
}
