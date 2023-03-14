public class Card {
    private String color;
    private String value;
    private boolean isActionCard;

    public Card(String color, String value, boolean isActionCard) {
        this.color = color;
        this.value = value;
        this.isActionCard = isActionCard;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public boolean isActionCard() {
        return isActionCard;
    }

    public boolean matches(Card otherCard) {
        if (isActionCard) {
            return color.equals(otherCard.getColor()) || value.equals(otherCard.getValue());
        } else {
            return color.equals(otherCard.getColor()) || value.equals(otherCard.getValue()) || otherCard.isActionCard();
        }
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
