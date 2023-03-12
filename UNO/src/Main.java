public class Main {
    public static void main(String[] args) {
        String[] playerNames = {"Alice", "Bob", "Charlie", "David"};
        Game game = new Game(playerNames);
        game.startGame();
        game.playGame();
    }
}
