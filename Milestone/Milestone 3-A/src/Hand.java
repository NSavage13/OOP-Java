import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card playCard(int index) {
        return cards.remove(index);
    }

    public int getSize() {
        return cards.size();
    }

    public boolean hasMatchingCard(Card topCard) {
        for (Card card : cards) {
            if (card.matches(topCard)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hand: ");
        for (Card card : cards) {
            builder.append(card.toString()).append(", ");
        }
        return builder.toString();
    }
}
