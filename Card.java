
public class Card {

    private char color;
    private char suit;
    private char value;
    public boolean isFaceUp;

    // Constructor
    public Card(char color, char suit, char value, boolean isFaceUp) {
        setColor(color);
        setSuit(suit);
        setValue(value);
        setFaceUp(isFaceUp);
    }

    public Card(char color, int suit, char value, boolean isFaceUp) {
        setColor(color);
        setSuit(suit);
        setValue(value);
        setFaceUp(isFaceUp);
    }

    // Getters
    public char getColor() {
        return color;
    }

    public char getSuit() {
        return suit;
    }

    public char getValue() {
        return value;
    }

    public boolean getFaceUp() {
        return isFaceUp;
    }

    // Setters
    public void setColor(char color) {
        if (color == 'R' || color == 'B') {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color must be R or B");
        }
        this.color = color;
    }

    public void setSuit(char suit) {
        if (suit == 'C' || suit == 'D' || suit == 'H' || suit == 'S') {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("Suit must be C, D, H, or S");
        }
        this.suit = suit;
    }

    public void setSuit(int suit) {
        switch (suit) {
            case 1:
                this.suit = 'C';
                break;
            case 2:
                this.suit = 'D';
                break;
            case 3:
                this.suit = 'H';
                break;
            case 4:
                this.suit = 'S';
                break;
            default:
                throw new IllegalArgumentException("Suit must be 1, 2, 3, or 4");
        }
    }

    // [A,2,3,4,5,6,7,8,9,T,J,Q,K]
    public void setValue(char value) {
        for(char c : new char[] {'A','2','3','4','5','6','7','8','9','T','J','Q','K'}) {
            if (value == c) {
                this.value = value;
                return;
            }
        }
        throw new IllegalArgumentException("Value must be A,2,3,4,5,6,7,8,9,T,J,Q,K");
    }

    public void setFaceUp(boolean isFaceUp) {
        this.isFaceUp = isFaceUp;
    }

    // Find the rank of the card based on the value 0-12 (A-K)
    // This could be writen as another method in the deck class or as a variable
    // that is set when the value is set
    public int getRank() {
        switch (value) {
            case 'A':
                return 0;
            case '2':
                return 1;
            case '3':
                return 2;
            case '4':
                return 3;
            case '5':
                return 4;
            case '6':
                return 5;
            case '7':
                return 6;
            case '8':
                return 7;
            case '9':
                return 8;
            case 'T':
                return 9;
            case 'J':
                return 10;
            case 'Q':
                return 11;
            case 'K':
                return 12;
            default:
                throw new IllegalArgumentException("Value must be A,2,3,4,5,6,7,8,9,T,J,Q,K");
        }
    }

    // toString
    @Override
    public String toString() {
        return "card [color=" + color + ", suit=" + suit + ", value=" + value + "]";
    }
}