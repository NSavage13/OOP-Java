/* 
1 - 0 card 
2 - 2,3,4,5,6,7,8,9,Draw Two,Skip,Reverse
4 - Wild and Wild Four 
*/ 

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;


public class Deck {
    private Card[] cards;
    private int cardsInDeck;

    public Deck(){
        cards = new Card[108];
    }

    //------------------------------------------------------------------------------------
    public void reset(){
        
        Card.Color[] colors = Card.Color.values();
        cardsInDeck = 0;

        // Set colors and add cards to cardsInDeck with Card[].
        // Use colors.length - 1 to not use WILD. Wild does not get a color.
        for (int i = 0; i < colors.length-1;i ++){

            // This sets one 0 value to each color and adds it to the deck
            Card.Color color = colors[i];
            cards[cardsInDeck++] = new Card(color, Card.Value.getValue(0));

            //Start at 1 so you do not use zero
            //Sets the rest of the NUMBER VALUES to each color twice
            for (int x = 1; x < 10; x++){
                cards[cardsInDeck++] = new Card(color, Card.Value.getValue(x));
                cards[cardsInDeck++] = new Card(color, Card.Value.getValue(x));
            }

            // Sets two actions cards per color
            Card.Value[] values = new Card.Value[]{Card.Value.DrawTwo, Card.Value.Skip, Card.Value.Reverse};
            for (Card.Value value : values){
                cards[cardsInDeck++] = new Card(color, value);
                cards[cardsInDeck++] = new Card(color, value);
            }
        }
        
        // Outside of the FOR statement because we did not include Wild in it. This creates 4 wild cards of both types.
        Card.Value[] values = new Card.Value[]{Card.Value.Wild, Card.Value.WildFour};
        for (int j = 0; j < 4; j++){
            for (Card.Value value : values){
                cards[cardsInDeck++] = new Card(Card.Color.Wild, value);
            }
        }

    }
    //------------------------------------------------------------------------------------

    //Replaces the deck with an array list of Uno cards (The StockPile)
    public void replaceDeckWith(ArrayList<Card> cards){
        this.cards = cards.toArray(new Card[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }

    //------------------------------------------------------------------------------------

    public Boolean isEmpty(){
        return cardsInDeck == 0;
    }

    //------------------------------------------------------------------------------------

    public void shuffle(){
        // Gets a random index of the array past the current index
        for (int i = 1; i < cards.length - 1; i++){
            int randomValue = (int)(Math.random() * 108) + 1;
            Card randomCard = cards[randomValue];
            cards[i] = randomCard;

        }
    }
    // public void shuffle() {
    //     Random random = new Random();
    //     for (int i = cards.length - 1; i > 0; i--) {
    //         int j = random.nextInt(i + 1);
    //         Card temp = cards[i];
    //         cards[i] = cards[j];
    //         cards[j] = temp;
    //     }
    // }
    

    //------------------------------------------------------------------------------------

    public Card drawCard() throws IllegalArgumentException {
        if (isEmpty()){
            throw new IllegalArgumentException("No more cards in the deck.");
        }
        return cards[--cardsInDeck];
    }

    //------------------------------------------------------------------------------------

    // For GUI 
    public ImageIcon drawCardImage() throws IllegalArgumentException{
        if (isEmpty()){
            throw new IllegalArgumentException("Can not draw card because the deck is empty");
        }
        return new ImageIcon(cards[--cardsInDeck].toString()+ ".png");
    }

    //------------------------------------------------------------------------------------

    //For when you have to draw multiple cards.
    public Card[] drawCard(int n) {
        if (n<0){
            throw new IllegalArgumentException("Must draw a positive amount of cards");
        }
        // if (n> cardsInDeck){
        //     throw new IllegalArgumentException("Can not draw because there are not enough in the deck.");
        // }
        Card[] ret = new Card[n];

        for (int i = 0; i < n; i++){
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Deck [cards=" + Arrays.toString(cards) + ", cardsInDeck=" + cardsInDeck + "]";
    }
}
