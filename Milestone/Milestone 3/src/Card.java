public class Card {

    enum Color {
        Red, Blue, Green, Yellow, Wild;
        
        // Throws colors in an array
        private static final Color[] colors = Color.values();
        
        public static Color getColor(int i){
            return Color.colors[i];
        }
    }

    enum Value {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Skip, Reverse, Wild, WildFour;

        // Throws vakues in an array
        private static final Value[] values = Value.values();

        public static Value getValue(int i){
            return Value.values[i];
        }
    }

    private final Color color;
    private final Value value;

    

    public Card(Card.Color color, Card.Value value) {
        this.color = color;
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + "_" + value;
    }

    
}
