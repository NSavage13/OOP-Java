public class UnoGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();

        // Deal 7 cards to each player
        for (int i = 0; i < 7; i++) {
            player1Hand.addCard(deck.drawCard());
            player2Hand.addCard(deck.drawCard());
        }

        // Display each player's hand
        System.out.println("Player 1: " + player1Hand);
        System.out.println("Player 2: " + player2Hand);
    }
}
