import java.util.*;

/*
 * TODO:
 * 
 * 1. Remove moves remaining
 * 2. Handle face down cards
 * 3. Refactor with new data structures
 * 
 */

public abstract class Checks {
	
	// Check if the card can be added to a given column
    public static boolean canMoveCardToColumn(Card card, LinkedList<Card> column) {
    	if (column.isEmpty()) {
    		if (card.getValue() == 'K') {
    			return true;
    		}
    	} else {
    		Card last = column.getLast();
    		if (card.getColor() != last.getColor() && card.getValue() == last.getValue() - 1) {
    			return true;
    		}
		}
    	return false;
    }
    
    // Check if the card can be added to any column
    public static boolean canMoveCardToTable(Card card, ArrayList<LinkedList<Card>> Columns) {
    	for (LinkedList<Card> column : Columns) {
    		if (canMoveCardToColumn(card, column)) {
        		return true;
    		}
    	}
    	return false;
    }
    
    // Check if the series of cards can be added to a given column
    public static boolean canMoveSeriesToColumn(LinkedList<Card> cards, LinkedList<Card> column) {
    	Card first = cards.getFirst();
    	if (canMoveCardToColumn(first, column)) {
    		return true;
    	}
        return false;
    }
    
    // Check if the series of cards can be added to any column
    public static boolean canMoveSeriesToTable(LinkedList<Card> cards, ArrayList<LinkedList<Card>> Columns) {
    	Card first = cards.getFirst();
    	if (canMoveCardToTable(first, Columns)) {
    		return true;
    	}
    	return false;
    }
    
    // Check if the card can be removed from a given column
    public static boolean canRemoveCardFromColumn(Card card, LinkedList<Card> column) {
    	if (!column.isEmpty()) {
    		Card last = column.getLast();
    		if (card == last) {
    			return true;
    		}
    	}
        return false;
    }
    
    // Check if the card can be removed from any column
    public static boolean canRemoveCardFromTable(Card card, ArrayList<LinkedList<Card>> Columns) {
    	for (LinkedList<Card> column : Columns) {
    		if (canRemoveCardFromColumn(card, column)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    // Check if the series of cards can be removed from a given column
    public static boolean canRemoveSeriesFromColumn(LinkedList<Card> cards, LinkedList<Card> column) {
    	Card first = cards.getFirst();
    	if (canRemoveCardFromColumn(first, column)) {
    		return true;
    	}
        return false;
    }
    
    // Check if the series of cards can be removed from any column
    public static boolean canRemoveSeriesFromTable(LinkedList<Card> cards, ArrayList<LinkedList<Card>> Columns) {
    	Card first = cards.getFirst();
    	if (canRemoveCardFromTable(first, Columns)) {
    		return true;
    	}
        return false;
    }
    
    // Check if the card can be added to a pillar
    public static boolean canMoveCardToPillar(Card card, Stack<Card> suit) {
    	if (suit.isEmpty()) {
    		if (card.getValue() == 'A') {
    			return true;
    		}
    	} else {
    		Card last = suit.lastElement();
    		if (card.getSuit() == last.getSuit() && card.getValue() == last.getValue() - 1) {
    			return true;
    		}
    	}
    	return false;
    }

    // Check if the card can be moved to any of the pillars (may not be needed)
    public static boolean canMoveCardToPillars(Card card, ArrayList<Stack<Card>> Suits) {
    	for (Stack<Card> suit : Suits) {
    		if (canMoveCardToPillar(card, suit)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    // If all suits have a King, then the game has been won
    public static boolean gameIsWon(ArrayList<Stack<Card>> Suits) {
    	for (Stack<Card> suit : Suits) {
    		if (suit.size() != 13) {
    			return false;
    		}
    	}
    	return true;
    }
    
    // Check if there are any valid moves remaining
	// This method only checks if the player can put down or pick up a given card or series. It needs to check if the player can make any more moves.
	// 
	// 1. Are there cards in the hand that they could draw? (maybe do or don't include the waste pile, because they'll always be able to draw from the waste pile)
	// 2. Are there cards cards on the table that they could pick up?
    public static boolean validMovesLeft(Card card, ArrayList<LinkedList<Card>> Columns, LinkedList<Card> cards, ArrayList<Stack<Card>> Suits) {
    	if (!canMoveCardToTable(card, Columns) && !canMoveSeriesToTable(cards, Columns) && !canRemoveCardFromTable(card, Columns) && !canRemoveSeriesFromTable(cards, Columns) && !canMoveCardToPillars(card, Suits)) {
    		return false;
    	}
        return true;
    }
}
