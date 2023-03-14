import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game {
    private int currentPlayer;
    private String[] playerIds;

    private Deck deck;
    private ArrayList<ArrayList<Card>> playerHand;
    private ArrayList<Card> stockpile;

    private Card.Color validColor;
    private Card.Value validValue;

    boolean gameDirection;

    public Game(String[] pids){
        deck = new Deck();
        deck.shuffle();
        stockpile = new ArrayList<Card>();

        playerIds = pids;
        currentPlayer = 0;
        gameDirection = false;

        playerHand = new ArrayList<ArrayList<Card>>();

        for (int i = 0; i < pids.length; i ++){
            ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }
    }

    public void start(Game game){
        Card card = deck.drawCard();
        validColor = card.getColor();
        validValue = card.getValue();
        // starts the game
        if (card.getValue() == Card.Value.Wild){
            start(game);
        }
        if (card.getValue() == Card.Value.WildFour || card.getValue() == Card.Value.DrawTwo){
            start(game);
        }
        if (card.getValue() == Card.Value.Skip){
            JLabel message = new JLabel(playerIds[currentPlayer] + " was skipped");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            // makes it so you can skip in either direction
            if (gameDirection == false){
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }else if(gameDirection == true){
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1){
                    currentPlayer = playerIds.length - 1;
                }
            }
        }
        if (card.getValue() == Card.Value.Reverse){
            JLabel message = new JLabel(playerIds[currentPlayer] + " game direction changed");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            gameDirection ^= true;
            currentPlayer = playerIds.length - 1;
        }
        stockpile.add(card);
    }
    public Card getTopCard(){
        return new Card(validColor, validValue);
    }

    public ImageIcon getTopCardImage(){
        return new ImageIcon(validColor + "-" + validValue, ".png");

    }

    public boolean isGameOver(){
        for (String player : this.playerIds){
            if (hasEmptyHand(player)){
                return true;
            }
        }
        return false;
    }

    public String getCurrentPlayer() {
        return this.playerIds[this.currentPlayer];
    }
    public String getPreviousPlayer(int i){
        int index = this.currentPlayer - i;
        if (index == -1){
            index = playerIds.length - 1;
        }
        return playerIds[index];
    }

    public String[] getPlayers(){
        return playerIds;
    }

    public ArrayList<Card> getPlayerHand(String pid){
        int index = Arrays.asList(playerIds).indexOf(pid);
        return playerHand.get(index);
    }

    public int getPlayerHandSize(String pid){
        return getPlayerHand(pid).size();
    }

    public Card getPlayeCard(String pid, int choice) {
        ArrayList<Card> hand = getPlayerHand(pid);
        return hand.get(choice);

    }

    public boolean hasEmptyHand(String pid){
        return getPlayerHand(pid).isEmpty();
    }
    public boolean validCardPlay(Card card){
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    public void checkPlayerTurn(String pid)  throws InvalidPlayerTurnException {
        if (this.playerIds[this.currentPlayer] != pid){
            throw new InvalidPlayerTurnException("it is not " + pid + " 's turn", pid);
        }
    }

    public void submitDraws(String pid) throws InvalidPlayerTurnException {
        checkPlayerTurn(pid);

        if(deck.isEmpty()){
            deck.replaceDeckWith(stockpile);
            deck.shuffle();
        }

        getPlayerHand(pid).add(deck.drawCard());
        if (gameDirection == false){
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        }else if(gameDirection == true){
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if (currentPlayer == -1){
                currentPlayer = playerIds.length - 1;
            }
        }

    }

    public void setColor(Card.Color color){
        validColor = color;
    }

    public void submitPlayerCard(String pid, Card card, Card.Color declaredColor) throws InvalidColorSubmissionException, InvalidPlayerTurnException, InvalidValueSubmissionException {
        checkPlayerTurn(pid);

        ArrayList<Card> pHand = getPlayerHand(pid);

        if (!validCardPlay(card)){
            if (card.getColor() == Card.Color.Wild){
                validColor = card.getColor();
                validValue = card.getValue();
            }

            if (card.getColor() != validColor){
                JLabel message = new JLabel("Invalid player move, expected color: " + validColor);
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidColorSubmissionException(message, card.getColor(), validColor);
            }
        }
    }
    

}

class InvalidPlayerTurnException extends Exception {
    String playerId;

    public InvalidPlayerTurnException(String message, String pid){
        super(message);
        playerId = pid;
    }
    public String getPid(){
        return playerId;
    }
}

class InvalidColorSubmissionException extends Exception {
    private Card.Color expected;
    private Card.Color actual;

    public InvalidColorSubmissionException(JLabel message, Card.Color actual, Card.Color expected){
        this.actual = actual;
        this.expected = expected;
    }
}

class InvalidValueSubmissionException extends Exception {
    private Card.Value expected;
    private Card.Value actual;

    public InvalidValueSubmissionException(String message, Card.Value actual, Card.Value expected){
        this.actual = actual;
        this.expected = expected;
    }
}