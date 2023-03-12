import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] colors = {"red", "blue", "green", "yellow"};
        String[] actions = {"skip", "reverse", "draw two", "wild", "wild draw four"};
        for (String color : colors) {
            for (int value = 0; value <= 9; value++) {
                cards.add(new Card(color, value, null));
                if (value != 0) {
                    cards.add(new Card(color, value, null));
                }
            }
            for (String action : actions) {
                cards.add(new Card(color, 10, action));
                cards.add(new Card(color, 10, action));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }
}
