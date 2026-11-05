import java.util.Objects;

class Card {
    private String rank;
    private String suit;

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // toString()
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Card c = (Card) obj;

        return rank.equals(c.rank) && suit.equals(c.suit);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

// Drivers class
class Drivers {
    public static void main(String[] args) {

        Card[] cards = new Card[5];

        Card[] newCards = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Clubs")
        };

        int count = 0;

        for (int i = 0; i < newCards.length; i++) {

            boolean duplicate = false;

            // Check earlier cards
            for (int j = 0; j < count; j++) {
                if (newCards[i].equals(cards[j])) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("Duplicate found: " + newCards[i]);
                break;
            }

            cards[count] = newCards[i];
            count++;
        }
    }
}