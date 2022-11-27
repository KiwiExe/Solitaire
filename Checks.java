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
    public boolean canMoveCardToPillar(Card card, char suit){
        return true;
    }
    public boolean gameIsWon(){
        return true;
    }
    public boolean movesLeft(){
        return true;
    }
    
    
}
