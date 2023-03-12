import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public void playCard(Card card, List<Card> discardPile) {
        hand.remove(card);
        discardPile.add(card);
    }

    public boolean checkUno() {
        return hand.size() == 1;
    }

    public boolean hasCard(Card card) {
        return hand.contains(card);
    }
}