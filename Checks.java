import java.util.*;

public abstract class Checks {

    public static boolean canMoveCardToTable(Card card, int column){
        return true;
    }
    public static boolean canMoveSeriesToTable(LinkedList<Card> cards, int column){
        return true;
    }
    public static boolean canRemoveCardFromTable(int column){
        return true;
    }
    public static boolean canRemoveSeriesFromTable(int column, int numCards){
        return true;
    }
    public static boolean canMoveCardToPillar(Card card, char suit){
        return true;
    }
    public static boolean gameIsWon(){
        return true;
    }
    public static boolean movesLeft(){
        return true;
    }
    public static boolean canRemoveFromTable(int column){
        return canRemoveCardFromTable(column);
    }
    public static boolean canRemoveFromTable(int column, int numCards){
        return canRemoveSeriesFromTable(column, numCards);
    }
    
    
}
