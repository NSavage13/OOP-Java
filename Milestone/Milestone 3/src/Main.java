public class Main {
    public static void main(String[] args) {
        String[] players = {"Player 1", "Player 2", "Player 3", "Player 4"};
        Deck deck = new Deck();
        deck.reset();
        deck.shuffle();
        Game game1 = new Game(players);
        game1.start(game1);
        
        
    }
}
