import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int currentPlayer;
    private int direction;
    private List<Card> discardPile;
    private Deck drawPile;
    private String winner;
    private boolean over = false;

    public Game(String[] playerNames) {
        players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        currentPlayer = 0;
        direction = 1;
        discardPile = new ArrayList<>();
        drawPile = new Deck();
        winner = null;
    }

    public void startGame() {
        drawPile.shuffle();
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCard(drawPile.draw());
            }
        }
        discardPile.add(drawPile.draw());
    }

    public void playGame() {
        while (over == false) {
            Player player = players.get(currentPlayer);
            System.out.println(player.getName() + "'s turn:");
            System.out.println("Current card: " + discardPile.get(discardPile.size() - 1).getColor() + " " + discardPile.get(discardPile.size() - 1).getValue() + " " + discardPile.get(discardPile.size() - 1).getAction());
            
            if (player.getHand().isEmpty()) {
                winner = player.getName();
                over = true;
                break;
            }
            Card card = null;
            for (Card c : player.getHand()) {
                if (c.getColor().equals(discardPile.get(discardPile.size() - 1).getColor()) || c.getValue() == discardPile.get(discardPile.size() - 1).getValue() || c.getAction() != null) {
                    card = c;
                    break;
                }
            }
            if (card != null) {
                if (card.getAction() != null) {
                    System.out.println("Playing " + card.getAction() + " card.");
                    if (card.getAction().equals("skip")) {
                        currentPlayer = (currentPlayer + direction + players.size()) % players.size();
                    } else if (card.getAction().equals("reverse")) {
                        direction = -direction;
                    } else if (card.getAction().equals("draw two")) {
                        Player nextPlayer = players.get((currentPlayer + direction + players.size()) % players.size());
                        for (int i = 0; i < 2; i++) {
                            nextPlayer.addCard(drawPile.draw());
                        }
                    } else if (card.getAction().equals("wild")) {
                        card = new Card(null, 10, "wild");
                    } else if (card.getAction().equals("wild draw four")) {
                        card = new Card(null, 10, "wild draw four");
                    }
                }
                player.playCard(card, discardPile);
                if (player.getHand().isEmpty()) {
                    winner = player.getName();
                    over = true;
                    break;
                }
                System.out.println(player.getName() + " played " + card.getColor() + " " + card.getValue() + " " + card.getAction() + ".");
                if (player.checkUno()) {
                    System.out.println(player.getName() + " has UNO!");
                }
                if (player.getHand().isEmpty()) {
                    winner = player.getName();
                    over = true;
                    break;
                }
                if (card.getAction() == null || card.getAction().equals("reverse") || card.getAction().equals("wild") || card.getAction().equals("wild draw four")) {
                    currentPlayer = (currentPlayer + direction + players.size()) % players.size();
                }
            } else {
                System.out.println(player.getName() + " cannot play any card and draws one.");
                player.addCard(drawPile.draw());
            }
        }
        System.out.println("Game over. " + winner + " wins!");
    }
}



