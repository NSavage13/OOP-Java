import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] colors = {"Red", "Yellow", "Green", "Blue"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};
        for (String color : colors) {
            cards.add(new Card(color, "0", false));
            for (int i = 1; i < values.length; i++) {
                cards.add(new Card(color, values[i], false));
                if (i < 10) {
                    cards.add(new Card(color, values[i], false));
                }
            }
            cards.add(new Card(color, "Skip", true));
            cards.add(new Card(color, "Reverse", true));
            cards.add(new Card(color, "Draw Two", true));
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new Card("Wild", "Wild", true));
            cards.add(new Card("Wild", "Draw Four", true));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }
}
